import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] shipRowMovement = {1, 1, 1};
    private static int[] shipColMovement = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int distance = Integer.parseInt(st.nextToken());
                map[i][j] = distance;
            }
        }

        int shortestDistanceToMoon = shortestDistanceToMoon();
        bw.write(String.valueOf(shortestDistanceToMoon));
        bw.flush();
    }

    private static int shortestDistanceToMoon() {
        Queue<ship> q = new LinkedList<>();
        for (int i = 0; i < map[0].length; i++) {
            q.add(new ship(0, i, map[0][i], -1));
        }
        
        int minCost = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                ship cur = q.poll();
                if (cur.r == N - 1) {
                    minCost = Math.min(minCost, cur.cost);
                }
                for (int j = 0; j < 3; j++) {
                    if (cur.prevMovementCode == j) {
                        continue;
                    }
                    int nr = cur.r + shipRowMovement[j];
                    int nc = cur.c + shipColMovement[j];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    int cost = cur.cost + map[nr][nc];

                    q.add(new ship(nr, nc, cost, j));
                }
            }
        }
        return minCost;
    }

    private static class ship {
        int r;
        int c;
        int cost = 0;
        int prevMovementCode;

        public ship(final int r, final int c, final int cost, final int prevMovementCode) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.prevMovementCode = prevMovementCode;
        }
    }
}
