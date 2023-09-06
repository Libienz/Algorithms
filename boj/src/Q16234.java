import java.util.*;
import java.io.*;

public class Q16234 {

    private static int N;
    private static int L;
    private static int R;
    private static int[][] map;
    private static boolean[][] visited;
    private static boolean[][][][] checked;
    private static boolean[][][][] open;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;

        while (true) {
            //열린 국경이 있는 지 확인
            if (!isAnyBoardOpen()) {
                break;
            }
//            System.out.println("day = " + day);
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        ArrayList<Country> allies = new ArrayList<>();
                        allies.add(new Country(i, j));
                        dfs(i, j, allies);
//                        System.out.println("allies = " + allies);

                        int newPop = 0;
                        for (Country country : allies) {
                            newPop += map[country.r][country.c];
                        }
                        newPop = newPop / allies.size();
//                        System.out.println("newPop = " + newPop);
                        for (Country country : allies) {
                            map[country.r][country.c] = newPop;
                        }

                    }
                }
            }

            day++;
        }

        System.out.println(day);
    }

    private static boolean isAnyBoardOpen() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int curPop = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nr = i + moveR[k];
                    int nc = j + moveC[k];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                        continue;
                    }
                    int neighborPop = map[nr][nc];
                    int diff = Math.abs(neighborPop - curPop);
                    if (diff >= L && diff <= R) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void dfs(int r, int c, ArrayList<Country> union) {

//        System.out.println("r = " + r);
//        System.out.println("c = " + c);
        int curPop = map[r][c];
        //인접 나라 살펴보기
        for (int k = 0; k < 4; k++) {
            int nr = r + moveR[k];
            int nc = c + moveC[k];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) {
                continue;
            }
            int neighborPop = map[nr][nc];
            int diff = Math.abs(neighborPop - curPop);
            if (diff >= L && diff <= R) {
                union.add(new Country(nr, nc));
                visited[nr][nc] = true;

                dfs(nr, nc, union);

            }

        }

    }

//    public static void adjustPopulation() {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                for (int )
//            }
//        }
//    }

    static class Country {
        private int r;
        private int c;

        public Country(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
