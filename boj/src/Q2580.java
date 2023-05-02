import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Space {
    private int r;
    private int c;

    public Space(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}
public class Q2580 {

    static int[][] board; //스도쿠 보드

    public static ArrayList<Integer> generateCheckSet() {
        ArrayList<Integer> checkSet = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            checkSet.add(i);
        }
        return checkSet;
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Space> spaces = new LinkedList<>(); //0인 공간들을 모아놓은 리스트
        //스도쿠 보드 초기화
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    Space s = new Space(i, j);
                    spaces.add(s);
                }
            }
        }
        while (!spaces.isEmpty()) {

            Space s = spaces.poll();
            //가로줄 검증
            ArrayList<Integer> checkSet = generateCheckSet();
            for (int i = 0; i < 9; i++) {
                if (board[s.getR()][i] != 0) {
                    checkSet.remove((Object) board[s.getR()][i]);
                }
            }
            if (checkSet.size() == 1) {
                board[s.getR()][s.getC()] = checkSet.get(0);
                spaces.remove(0);
                continue;
            }
            //세로줄 검증
            checkSet = generateCheckSet();
            for (int i = 0; i < 9; i++) {
                if (board[i][s.getC()] != 0) {
                    checkSet.remove((Object) board[i][s.getC()]);
                }
            }
            if (checkSet.size() == 1) {
                board[s.getR()][s.getC()] = checkSet.get(0);
                spaces.remove(0);
                continue;
            }
            //사각형 검증
            checkSet = generateCheckSet();
            int qr = s.getR() / 3;
            int qc = s.getC() / 3;
            for (int i = qr*3; i < qr*3 + 3; i++) {
                for (int j = qc * 3; j < qc * 3 + 3; j++) {
                    if (board[i][j] != 0) {
                        checkSet.remove((Object) board[i][j]);
                    }
                }
            }
            if (checkSet.size() == 1) {
                board[s.getR()][s.getC()] = checkSet.get(0);
                spaces.remove(0);
                continue;
            }
            //아무런 조건으로도 못찾으면 다시 큐로..
            spaces.add(s);

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
}
