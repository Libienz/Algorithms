import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int result = 0;

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pipeStartRow = 0;
        int pipeStartCol = 0;
        int pipeEndRow = 0;
        int pipeEndCol = 1;

        dfs(pipeStartRow, pipeStartCol, pipeEndRow, pipeEndCol);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void dfs(int sr, int sc, int er, int ec) {

        if (er == N - 1 && ec == N - 1) {
            result++;
            return;
        }

        if (sr == er && ec - sc == 1) {
            if (canPutPipe(sr, sc + 1, er, ec + 1)) {
                dfs(sr, sc + 1, er, ec + 1);
            }
            if (canPutPipe(sr, sc + 1, er + 1, ec + 1)) {
                dfs(sr, sc + 1, er + 1, ec + 1);
            }
        } else if (sc == ec && er - sr == 1) {
            if (canPutPipe(sr + 1, sc, er + 1, ec)) {
                dfs(sr + 1, sc, er + 1, ec);
            }
            if (canPutPipe(sr + 1, sc, er + 1, ec + 1)) {
                dfs(sr + 1, sc, er + 1, ec + 1);
            }
        } else {
            if (canPutPipe(sr + 1, sc + 1, er, ec + 1)) {
                dfs(sr + 1, sc + 1, er, ec + 1);
            }
            if (canPutPipe(sr + 1, sc + 1, er + 1, ec)) {
                dfs(sr + 1, sc + 1, er + 1, ec);
            }
            if (canPutPipe(sr + 1, sc + 1, er + 1, ec + 1)) {
                dfs(sr + 1, sc + 1, er + 1, ec + 1);
            }
        }
    }

    private static boolean canPutPipe(int sr, int sc, int er, int ec) {
        if (sr < 0 || sc < 0 || er < 0 || ec < 0) {
            return false;
        }
        if (sr >= N || sc >= N || er >= N || ec >= N) {
            return false;
        }
        if (er - sr == 1 && ec - sc == 1) {
            if (map[er - 1][ec] == 1 || map[er][ec - 1] == 1) {
                return false;
            }
        }
        if (map[sr][sc] == 1 || map[er][ec] == 1) {
            return false;
        }
        return true;
    }
}

