import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            int count = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                map[r][c] = 1;
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
//                    System.out.println("j = " + j);
//                    System.out.println("k = " + k);
//                    System.out.println("map[j][k] = " + map[j][k]);

                    if (map[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();

        }
        bw.flush();
    }


    public static void dfs(int r, int c) {
        if (visited[r][c]) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + moveR[i];
            int nc = c + moveC[i];
            if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) {
                continue;
            }
            if (map[nr][nc] == 1) {
                visited[r][c] = true;
                dfs(nr, nc);
            }
        }
    }
}