import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, 1, -1};

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean visited[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        int count = bfs();

        bw.write(String.valueOf(count));
        bw.flush();
    }

    public static int bfs() {
        Queue<Position> q = new LinkedList<>();
        int count = 0;
        q.add(new Position(0, 0, 1));
        visited[0][0][1] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Position cur = q.poll();
                if (cur.r == N - 1 && cur.c == M - 1) {
                    return count + 1;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + moveR[j];
                    int nc = cur.c + moveC[j];

                    if (nr >= N || nc >= M || nr < 0 || nc < 0) {
                        continue;
                    }

                    if (map[nr][nc] == 1) {
                        if (cur.breakCount <= 0) {
                            continue;
                        }
                        if (visited[nr][nc][cur.breakCount - 1]) {
                            continue;
                        }
                        q.add(new Position(nr, nc, cur.breakCount - 1));
                        visited[nr][nc][cur.breakCount - 1] = true;
                    } else {
                        if (visited[nr][nc][cur.breakCount]) {
                            continue;
                        }
                        q.add(new Position(nr, nc, cur.breakCount));
                        visited[nr][nc][cur.breakCount] = true;
                    }
                }

            }
            count++;
        }
        return -1;
    }

    private static class Position {
        int r;
        int c;
        int breakCount;

        public Position(int r, int c, int breakCount) {
            this.r = r;
            this.c = c;
            this.breakCount = breakCount;
        }
    }
}
