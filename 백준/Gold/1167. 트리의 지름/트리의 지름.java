import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int V;
    private static List<Node>[] tree;
    private static boolean[] visited;
    private static int maxIndex;
    private static int max_distance = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        tree = new List[V + 1];
        for (int i = 0; i < V + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while (true) {
                int dest = Integer.parseInt(st.nextToken());
                if (dest == -1) {
                    break;
                }
                int dist = Integer.parseInt(st.nextToken());
                tree[start].add(new Node(dest, dist));
            }
        }

        visited = new boolean[V + 1];
        visited[1] = true;
        dfs(1, 0);

        Arrays.fill(visited, false);
        visited[maxIndex] = true;
        dfs(maxIndex, 0);

        bw.write(String.valueOf(max_distance));
        bw.flush();
    }

    public static void dfs(int start, int distance) {

        if (distance > max_distance) {
            max_distance = distance;
            maxIndex = start;
        }

        for (Node n : tree[start]) {
            if (visited[n.dest]) {
                continue;
            }
            visited[n.dest] = true;
            dfs(n.dest, n.dist + distance);
        }
    }

    private static class Node {
        private int dest;
        private int dist;

        public Node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }
    }
}
