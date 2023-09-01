import java.util.*;

public class Q1726 {

    private static int rowSize;
    private static int colSize;
    private static int sr;
    private static int sc;
    private static int sd;
    private static int dr;
    private static int dc;
    private static int dd;

    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] moveR = {0, 0, 1, -1};
    private static int[] moveC = {-1, 1, 0, 0};
    private static int[] turnD = {1, -1};
    private static int[] depth = {1, 2, 3};



    public static void main(String[] args) {

        //요소 초기화
        Scanner scanner = new Scanner(System.in);
        rowSize = scanner.nextInt();
        colSize = scanner.nextInt();
        visited = new boolean[rowSize][colSize][4];
        map = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        sr = scanner.nextInt()-1;
        sc = scanner.nextInt()-1;
        sd = scanner.nextInt()-1;

        dr = scanner.nextInt()-1;
        dc = scanner.nextInt()-1;
        dd = scanner.nextInt()-1;

        int res = bfs();
        System.out.println("res = " + res);
    }

    public static int bfs() {

        Queue<Status> q = new LinkedList<>();
        Status start = new Status(sr, sc, sd);
        visited[sr][sc][sd] = true;
        int level = 0;
        q.add(start);

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {
                Status cur = q.poll();
                System.out.println();
                if (cur.getR() == dr && cur.getC() == dc && cur.getD() == dd) {
                    return level;
                }
                //회전
                for (int j = 0; j < 2; j++) {
                    int nd = turnDirect(cur.getD(), j);
                    if (!visited[cur.getR()][cur.getC()][nd]) {
                        q.add(new Status(cur.getR(), cur.getC(), nd));
                        visited[cur.getR()][cur.getC()][nd] = true;
                    }
                }
                //움직이기
                for (int j = 1; j <= 3; j++) {
                    if (cur.d == 0) { //동
                        int nr = cur.r;
                        int nc = cur.c + 1 * j;
                        int nd = cur.d;

                        if (nr >= 0 && nc >= 0 && nr < rowSize && nc < colSize && !visited[nr][nc][nd]) {
                            if (map[nr][nc] == 1) {
                                break;
                            }
                            q.add(new Status(nr, nc, nd));
                            visited[nr][nc][nd] = true;
                        }
                    }
                    if (cur.d == 1) { //서
                        int nr = cur.r;
                        int nc = cur.c + (-1) * j;
                        int nd = cur.d;

                        if (nr >= 0 && nc >= 0 && nr < rowSize && nc < colSize && !visited[nr][nc][nd]) {
                            if (map[nr][nc] == 1) {
                                break;
                            }
                            q.add(new Status(nr, nc, nd));
                            visited[nr][nc][nd] = true;
                        }
                    }
                    if (cur.d == 2) { //남
                        int nr = cur.r + 1 * j;
                        int nc = cur.c;
                        int nd = cur.d;

                        if (nr >= 0 && nc >= 0 && nr < rowSize && nc < colSize && !visited[nr][nc][nd]) {
                            if (map[nr][nc] == 1) {
                                break;
                            }
                            q.add(new Status(nr, nc, nd));
                            visited[nr][nc][nd] = true;
                        }
                    }
                    if (cur.d == 3) { //북
                        int nr = cur.r + (-1) * j;
                        int nc = cur.c;
                        int nd = cur.d;

                        if (nr >= 0 && nc >= 0 && nr < rowSize && nc < colSize && !visited[nr][nc][nd]) {
                            if (map[nr][nc] == 1) {
                                break;
                            }
                            q.add(new Status(nr, nc, nd));
                            visited[nr][nc][nd] = true;
                        }
                    }
                }

            }
            level++;
        }
        return -1;
    }

    public static int turnDirect(int curDirection, int turnMode) {
        //왼쪽으로 돌기
        if (turnMode == 0) {
            //동
            if (curDirection == 0) {
                return 3;
            }
            //서
            if (curDirection == 1) {
                return 2;
            }
            //남
            if (curDirection == 2) {
                return 0;
            }
            //북
            if (curDirection == 3) {
                return 1;
            }
        }
        //오른쪽으로 돌기
        else {
            //동
            if (curDirection == 0) {
                return 2;
            }
            //서
            if (curDirection == 1) {
                return 3;
            }
            //남
            if (curDirection == 2) {
                return 1;
            }
            //북
            if (curDirection == 3) {
                return 0;
            }
        }
        return 999;
    }

    static class Status{
        private int r;
        private int c;
        private int d;

        public Status(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getD() {
            return d;
        }

        @Override
        public String toString() {
            return "Status{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }
}
