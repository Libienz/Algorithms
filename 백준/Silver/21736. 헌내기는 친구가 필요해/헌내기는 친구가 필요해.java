import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int[] MOVE_R = {-1, 1, 0, 0};
    private static final int[] MOVE_C = {0, 0, 1, -1};

    private static int sr;
    private static int sc;

    private static char[][] map;
    private static boolean[][] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'I') {
                    sr = i;
                    sc = j;
                }
                map[i][j] = line.charAt(j);
            }
        }

        visited[sr][sc] = true;
        dfs(sr, sc);
        if (result == 0) {
            bw.write("TT");
        } else {
            bw.write(String.valueOf(result));
        }
        bw.flush();
    }

    private static void dfs(int r, int c) {
//        System.out.println("r = " + r);
//        System.out.println("c = " + c);
        for (int i = 0; i < 4; i++) {
            int nr = r + MOVE_R[i];
            int nc = c + MOVE_C[i];
//            System.out.println("nr = " + nr);
//            System.out.println("nc = " + nc);
            if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            if (map[nr][nc] == 'X') {
                continue;
            }
            if (map[nr][nc] == 'P') {
                result++;
            }
            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}
