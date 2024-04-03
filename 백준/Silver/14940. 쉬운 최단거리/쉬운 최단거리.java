import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] MOVE_R = {0, 0, 1, -1};
    private static final int[] MOVE_C = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int sr = 0;
        int sc = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 2) {
                    sr = i;
                    sc = j;
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = number;
            }
        }

        bfs(map, new Point(sr, sc));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(map[i][j] + " ");
            }
            if (i != n - 1) {
                bw.newLine();
            }
        }
        bw.flush();
    }

    public static void bfs(int[][] map, Point start) {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[map.length][map[0].length];
        visited[start.r][start.c] = true;
        int hop = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + MOVE_R[j];
                    int nc = cur.c + MOVE_C[j];

                    if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) {
                        continue;
                    }
                    if (map[nr][nc] == 0 || visited[nr][nc]) {
                        continue;
                    }
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;

                    map[nr][nc] = hop;
                }
            }
            hop++;
        }
    }

    private static class Point {
        private final int r;
        private final int c;

        public Point(int r, int c) {
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
}
