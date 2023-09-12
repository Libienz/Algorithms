import java.io.*;
import java.util.ArrayList;

public class Q11559 {

    private final static int ROW_SIZE = 12;
    private final static int COL_SIZE = 6;
    private static char[][] board;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static boolean explosion;




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new char[ROW_SIZE][COL_SIZE];
        visited = new boolean[ROW_SIZE][COL_SIZE];

        for (int i = 0; i < ROW_SIZE; i++) {
            String row = br.readLine();
            for (int j = 0; j < COL_SIZE; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == '.') {
                    visited[i][j] = true;
                }
            }
        }

        int res = countChain();
        bw.write(res + "");
        bw.flush();
    }

    public static int countChain() {

        int count = 0;
        explosion = true;
        while (explosion) {
            drop();
//            System.out.println("after drop");
//            printBoard();
//            System.out.println();
            explosion = false;
            visited = new boolean[ROW_SIZE][COL_SIZE];
            for (int i = 0; i < ROW_SIZE; i++) {
                for (int j = 0; j < COL_SIZE; j++) {

                    //i,j 위치가 연결된 것들과 함께 터지는 지 확인
                    if (visited[i][j] || board[i][j] == '.') {
                        continue;
                    }
                    ArrayList<Node> linked = new ArrayList<>();
                    dfs(i, j, board[i][j], linked);

                    if (linked.size() >= 4) {
                        for (Node n : linked) {
                            board[n.r][n.c] = '.';
                        }
                        explosion = true;
                    }
                }
            }


//            System.out.println("after boom");
//            printBoard();
//            System.out.println();
            count++;
        }
        return count - 1;
    }

    //각 열에 중력의 영향을 받도록 하는 메서드
    public static void drop() {
        for (int i = 0; i < COL_SIZE; i++) {
            for (int j = ROW_SIZE - 2; j >= 0; j--) {
                char cur = board[j][i];
                //빈공간이 아니라면 떨어질 수 있을 때 까지 떨어뜨린다.
                if (cur != '.') {
                    int downR = j + 1;
                    while (downR != ROW_SIZE && board[downR][i] == '.') {
                        downR++;
                    }

                    board[j][i] = '.';
                    board[downR-1][i] = cur;
                }
            }
        }
    }

    //dfs explode
    public static void dfs(int r, int c, char ch, ArrayList<Node> linked) {

        //4방향 살펴보기
        for (int k = 0; k < 4; k++) {
            int nr = r + moveR[k];
            int nc = c + moveC[k];
            if (nr < 0 || nc < 0 || nr >= ROW_SIZE || nc >= COL_SIZE || visited[nr][nc] || board[nr][nc] != ch) {
                continue;
            }
            visited[nr][nc] = true;
            linked.add(new Node(nr, nc));
            dfs(nr, nc, ch, linked);
        }

    }

    public static void printBoard() {
        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COL_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Node {

        private int r;
        private int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
