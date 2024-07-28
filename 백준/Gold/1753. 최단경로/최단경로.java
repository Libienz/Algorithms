import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int vertexCount;
    private static int edgeCount;
    private static int startPoint;
    private static ArrayList<Node>[] graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertexCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        startPoint = Integer.parseInt(br.readLine()) - 1;

        graph = new ArrayList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            graph[i] = new ArrayList<>();
        }

        dist = new int[vertexCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startPoint] = 0;

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(startPoint);

        for (int i = 0; i < vertexCount; i++) {
            int distance = dist[i];
            if (distance == Integer.MAX_VALUE) {
                bw.write("INF");
            } else {
                bw.write(String.valueOf(distance));
            }
            bw.newLine();
        }
        bw.flush();
    }

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        boolean[] checked = new boolean[vertexCount];

        while (!pq.isEmpty()) {
            int cur = pq.poll().dest;
            for (Node nextNode : graph[cur]) {
                if (checked[cur]) {
                    continue;
                }
//                checked[cur] = true;

                int nextPosition = nextNode.dest;
                int weight = nextNode.weight;
                int nextPositionDistance = Math.min(
                        dist[cur] + weight,
                        dist[nextPosition]
                );
                if (dist[nextPosition] > nextPositionDistance) {
                    dist[nextPosition] = nextPositionDistance;
                    pq.add(new Node(nextPosition, dist[nextPosition]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {

        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
