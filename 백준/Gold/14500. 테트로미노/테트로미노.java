import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int[] MOVE_R = {0, 0, 1, -1};
    private static final int[] MOVE_C = {1, -1, 0, 0};

    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int M;
    private static int maxSum = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }
        bw.write(String.valueOf(maxSum));
        bw.flush();
    }

    private static void dfs(int row, int col, int sum, int moveCount) {
        if (moveCount == 4) {
            if (sum > maxSum) {
                maxSum = sum;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + MOVE_R[i];
            int nc = col + MOVE_C[i];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            if (moveCount == 2) {
                visited[nr][nc] = true;
                dfs(row, col, sum + map[nr][nc], moveCount + 1);
                visited[nr][nc] = false;
            }
            visited[nr][nc] = true;
            dfs(nr, nc, sum + map[nr][nc], moveCount + 1);
            visited[nr][nc] = false;
        }
    }
}
