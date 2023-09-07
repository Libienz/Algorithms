import java.util.*;
import java.io.*;

public class Q11403 {

    private static int N;
    private static int[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(graph[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }

    public static void dfs(int sn, int cur) {
        for (int i = 0; i < N; i++) {
            if (graph[sn][i] == 1 && !visited[i]) {
                graph[cur][i] = 1;
                visited[i] = true;
                dfs(i, cur);
            }
        }
    }

}
