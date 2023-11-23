import java.util.*;
import java.io.*;

public class Main {

    private static char[][] board;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        board = new char[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            String row = br.readLine();
            for (int j = 0; j < colSize; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int minCount = Integer.MAX_VALUE;

        List<char[][]> subBoards = getSubBoards(board, 8);
//        System.out.println("subBoards = " + subBoards.size());
        for (char[][] subBoard : subBoards) {
            int count = calcCount(subBoard);
//            for (int i = 0; i < subBoard.length; i++) {
//                for (int j = 0; j < subBoard[0].length; j++) {
//                    System.out.print(subBoard[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("count = " + count);
            if (count < minCount) {
                minCount = count;
            }
        }

        bw.write(minCount + "");
        bw.flush();

    }

    public static List<char[][]> getSubBoards(char[][] board, int size) {
        List<char[][]> res = new ArrayList<>();
        int sr = 0;
        int sc = 0;
        for (int i = 0; i <= board.length - 8; i++) {
            for (int j = 0; j <= board[0].length - 8; j++) {
                char[][] subBoard = new char[size][size];
                //왼쪽 시작지점이 i,j일때
                sr = i;
                sc = j;

                for (int k = 0; k < size; k++) {
                    for (int l = 0; l < size; l++) {
                        subBoard[k][l] = board[sr + k][sc + l];
                    }
                }
                res.add(subBoard);
            }
        }

        return res;
    }

    public static int calcCount(char[][] board) {
        int minCount = Integer.MAX_VALUE;

        //W로 시작하게 할 경우
        int count = 0;
        char prev = 'W';
        if (board[0][0] != 'W') {
            count++;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

//                System.out.println("board[" + i + "][" + j + "] = " + board[i][j]);
//                System.out.println("prev = " + prev);
                if (board[i][j] == prev) {
                    count++;
                }
                if (prev == 'W') {
                    prev = 'B';
                } else {
                    prev = 'W';
                }
            }
            if (prev == 'W') {
                prev = 'B';
            } else {
                prev = 'W';
            }
        }
        if (count < minCount) {
            minCount = count;
        }

        //B로 시작하게 할 경우
        count = 0;
        prev = 'B';
        if (board[0][0] != 'B') {
            count++;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (board[i][j] == prev) {
                    count++;
                }
                if (prev == 'W') {
                    prev = 'B';
                } else {
                    prev = 'W';
                }
            }
            if (prev == 'W') {
                prev = 'B';
            } else {
                prev = 'W';
            }
        }
        if (count < minCount) {
            minCount = count;
        }
        return minCount;
    }
}
