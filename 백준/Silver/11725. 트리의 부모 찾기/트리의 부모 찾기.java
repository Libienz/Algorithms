import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static boolean[] visited;
    private static List<Integer>[] graph;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        parents = new int[N + 1];
        graph = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        visited[1] = true;
        dfs(1, 0);

        for (int i = 2; i <= N; i++) {
            bw.write(String.valueOf(parents[i]));
            bw.newLine();
        }
        bw.flush();
    }

    public static void dfs(int cur, int prev) {
        parents[cur] = prev;

        for (int canGo : graph[cur]) {
            if (visited[canGo]) {
                continue;
            }
            visited[canGo] = true;
            dfs(canGo, cur);
        }
    }
}

