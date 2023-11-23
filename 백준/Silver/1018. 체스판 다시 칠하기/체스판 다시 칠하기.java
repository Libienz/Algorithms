import java.util.*;
import java.io.*;

public class Main {

    private static char[][] board;
    private static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        // 보드 초기화
        board = new char[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            String row = br.readLine();
            for (int j = 0; j < colSize; j++) {
                board[i][j] = row.charAt(j);
            }
        }


        //i,j에서 시작하는 8사이즈의 정사각형 부분 배열에서 몇개를 바꾸면 체스판의 조건을 만족하는지 체크
        for (int i = 0; i <= rowSize - 8; i++) {
            for (int j = 0; j <= colSize - 8; j++) {
                int count = calcCount(i, j);
                if (count < minCount) {
                    minCount = count;
                }
            }
        }

        bw.write(minCount + "");
        bw.flush();

    }

    private static int calcCount(int sr, int sc) {
        char prev = 'W';
        int count = 0;
        //검은색으로 시작하는 경우 몇개를 고쳐 색칠해야 하는지 계산
        for (int i = sr; i < sr + 8; i++) {
            for (int j = sc; j < sc + 8; j++) {
                char currentColor = board[i][j];
                //이전과 현재의 색깔이 같다면 다시 색칠
                if (prev == currentColor) {
                    count++;
                }
                prev = reverseColor(prev);
            }
            //줄이 바뀌는 경우는 한번 이전 색깔 반전 필요
            prev = reverseColor(prev);
        }
        //검은색으로 시작하는 경우 색칠해야 하는 개수 : count
        //하얀색으로 시작하는 경우 색칠해야 하는 개수 : 64 - count
        return Math.min(count, 64 - count);
    }

    public static char reverseColor(char color) {
        if (color == 'B') {
            return 'W';
        }
        return 'B';
    }
}
