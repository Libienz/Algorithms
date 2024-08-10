import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int destination = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            map[start][destination] = Math.min(map[start][destination], weight);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int destination = Integer.parseInt(st.nextToken()) - 1;

        bw.write(String.valueOf(dijkstra(start, destination)));
        bw.flush();
    }

    public static int dijkstra(int start, int destination) {
        int[] costFromStart = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(costFromStart, Integer.MAX_VALUE);
        costFromStart[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.position]) {
                continue;
            }
            visited[cur.position] = true;

            for (int dest = 0; dest < N; dest++) {
                if (map[cur.position][dest] == Integer.MAX_VALUE) {
                    continue;
                }
                int costToDest = costFromStart[cur.position] + map[cur.position][dest];
                if (costToDest < costFromStart[dest]) {
                    costFromStart[dest] = costToDest;
                    pq.add(new Node(dest, costToDest));
                }
            }
        }

        return costFromStart[destination] == Integer.MAX_VALUE ? -1 : costFromStart[destination];
    }

    private static class Node implements Comparable<Node> {
        int position;
        int cost;

        public Node(int position, int cost) {
            this.position = position;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
