import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] MOVE_R = {-1, 1, 0, 0};
    private static final int[] MOVE_C = {0, 0, 1, -1};

    private static int N;
    private static int M;
    private static int[][] map;
    private static List<Node> chickenStorePositions = new ArrayList<>();
    private static int minChickenStoreDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickenStorePositions.add(new Node(i, j));
                }
            }
        }

        dfs(0, 0);
        bw.write(String.valueOf(minChickenStoreDistance));
        bw.flush();
    }

    private static void dfs(int idx, int deletedCount) {
        if (chickenStorePositions.size() - deletedCount == M) {
            int cityChickenDistance = calculateCityChickenDistance();
            minChickenStoreDistance = Math.min(minChickenStoreDistance, cityChickenDistance);
            return;
        }

        for (int i = idx; i < chickenStorePositions.size(); i++) {
            Node chickenStorePosition = chickenStorePositions.get(i);
            map[chickenStorePosition.r][chickenStorePosition.c] = 0;
            dfs(i + 1, deletedCount + 1);
            map[chickenStorePosition.r][chickenStorePosition.c] = 2;
        }
    }

    private static int calculateCityChickenDistance() {

        int[][] chickenDistance = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(chickenDistance[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    bfs(i, j, chickenDistance);
                }
            }
        }
        int cd = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (chickenDistance[i][j] != Integer.MAX_VALUE) {
                    cd += chickenDistance[i][j];
                }
            }
        }
        return cd;
    }

    private static void bfs(int row, int col, int[][] chickenDistance) {
        Queue<Node> q = new LinkedList<>();
        int distance = 0;
        boolean[][] visited = new boolean[N][N];
        visited[row][col] = true;
        q.add(new Node(row, col));

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if (map[cur.r][cur.c] == 1 && chickenDistance[cur.r][cur.c] > distance) {
                    chickenDistance[cur.r][cur.c] = distance;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + MOVE_R[j];
                    int nc = cur.c + MOVE_C[j];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    q.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
            distance++;
        }
    }

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

