import java.util.*;
import java.io.*;

public class Main {

    private static int[][] graph;
    private static boolean[] visited;
    private static int res;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        for (int i = 0; i < N; i++) {

            if (!visited[i]) {
                dfs(i);
                res++;
            }
        }
        bw.write(res + "");
        bw.flush();

    }

    public static void dfs(int sn) {

        visited[sn] = true;
        for (int i = 0; i < N; i++) {
            if (graph[sn][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }


    }
}
