import java.util.*;

//DFS 문제

public class Q2583 {

    static int[][] board;
    static int m;
    static int n;
    static int k;

    static int sa;
    static int cnt;
    static ArrayList<Integer> areas = new ArrayList<>();

    public static boolean isAvailableCoord(int r, int c) {
        if (r >= 0 && r < m && c >= 0 && c < n) {
            return true;
        }
        return false;
    }
    public static void dfs(int r, int c) {

        board[r][c] = 1;
        //stack frame의 특징을 이용한 dfs
        //한 방향으로 갈 수 있는 곳 까지 파고든 후 back tracking한다.
        //visit 배열을 사용하지 않고 방문한 곳은 1로 바꾸어 처리
        sa++;
        //상
        if (isAvailableCoord(r - 1, c) && board[r - 1][c] == 0) {
            board[r - 1][c] = 1;
            dfs(r - 1, c);
        }
        //하
        if (isAvailableCoord(r + 1, c) && board[r + 1][c] == 0) {
            board[r + 1][c] = 1;
            dfs(r + 1, c);
        }
        //좌
        if (isAvailableCoord(r, c - 1) && board[r][c - 1] == 0) {
            board[r][c - 1] = 1;
            dfs(r, c - 1);
        }
        //우
        if (isAvailableCoord(r, c + 1) && board[r][c + 1] == 0) {
            board[r][c + 1] = 1;
            dfs(r, c + 1);
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        //모눈 종이 초기화
        board = new int[m][n];


        //직사각형들 정보 입력 받기
        for (int i = 0; i < k; i++) {
            int lvx = sc.nextInt();
            int lvy = sc.nextInt();
            int rvx = sc.nextInt();
            int rvy = sc.nextInt();
            //직사각형 정보 기반으로 board 칠하기
            for (int r = m - rvy; r < m - lvy; r++) {
                for (int c = lvx; c < rvx; c++) {
                    board[r][c] = 1;
                }
            }
        }

        //board를 뒤져가며 0이 나오는 위치를 찾는다.
        //해당 위치에서 dfs를 이용, 0인 영역의 넓이를 구한다.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    sa = 0;
                    dfs(i, j);
                    areas.add(sa);
                    cnt++;

                }
            }
        }

        System.out.println(cnt);
        Collections.sort(areas);
        for (int a : areas) {
            System.out.print(a + " ");
        }




    }
}
