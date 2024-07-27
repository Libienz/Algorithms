import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Node>[] tree;
    private static int n;
    private static boolean visited[];
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            tree[p].add(new Node(c, w));
            tree[c].add(new Node(p, w));
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, 0);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static void dfs(int start, int weight) {
        answer = Math.max(weight, answer);

        for (Node canGo : tree[start]) {
            if (visited[canGo.position]) {
                continue;
            }
            visited[canGo.position] = true;
            dfs(canGo.position, weight + canGo.weight);
        }
    }

    private static class Node {
        int position;
        int weight;

        public Node(int position, int weight) {
            this.position = position;
            this.weight = weight;
        }
    }
}



