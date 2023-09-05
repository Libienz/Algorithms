import java.util.*;
import java.io.*;

public class Q1260 {

    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        for (int i = 0; i < graph.size(); i++) {
            ArrayList<Integer> arr = graph.get(i);
            Collections.sort(arr);
        }


        visited = new boolean[N];
        visited[V] = true;
        dfs(V);
        System.out.println();
        visited = new boolean[N];
        visited[V] = true;
        bfs(V);
        System.out.println();
    }

    public static void dfs(int sn) {

        ArrayList<Integer> canGoList = graph.get(sn);
        System.out.print(sn + 1 +" ");

        for (Integer n : canGoList) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(n);
            }
        }
    }

    public static void bfs(int sn) {
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(sn);

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer cur = q.poll();
                System.out.print(cur + 1 + " ");
                ArrayList<Integer> canGoList = graph.get(cur);
                for (Integer next : canGoList) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }
    }
}
