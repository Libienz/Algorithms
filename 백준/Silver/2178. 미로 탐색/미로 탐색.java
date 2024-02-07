import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static final int startRow = 0;
    private static final int startCol = 0;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};
    private static int N;
    private static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - 48;
            }
        }

        int step = countStep();
        bw.write(String.valueOf(step));
        bw.flush();
    }

    public static int countStep() {
        Queue<Point> q = new LinkedList<>();
        int step = 0;

        q.add(new Point(startRow, startCol));
        visited[startRow][startCol] = true;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                if (cur.r == N - 1 && cur.c == M - 1) {
                    return step + 1;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + moveR[j];
                    int nc = cur.c + moveC[j];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
                        Point nextPoint = new Point(nr, nc);
                        q.add(nextPoint);
                        visited[nr][nc] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    static class Point {
        private int r;
        private int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}