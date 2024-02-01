import java.util.*;
import java.io.*;

public class Main {
    private static boolean[][] graph;
    private static int N;
    private static int M;
    private static int V;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sn = Integer.parseInt(st.nextToken()) - 1;
            int en = Integer.parseInt(st.nextToken()) - 1;
            graph[sn][en] = true;
            graph[en][sn] = true;
        }

        visited = new boolean[N];
        visited[V - 1] = true;
        printDfs(V - 1, bw);
        bw.newLine();
        bw.flush();

        visited = new boolean[N];
        printBfs(bw);
        bw.newLine();
        bw.flush();
    }

    public static void printDfs(int n, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(n + 1) + " ");
        for (int i = 0; i < N; i++) {
            if (graph[n][i] && !visited[i]) {
                visited[i] = true;
                printDfs(i, bw);
            }
        }
    }

    public static void printBfs(BufferedWriter bw) throws IOException {

        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(V - 1);
        visited[V - 1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            bw.write(String.valueOf(cur + 1) + " ");
            for (int i = 0; i < N; i++) {
                if (graph[cur][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
            level++;
        }
    }
}
