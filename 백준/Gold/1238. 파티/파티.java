import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;
    static List<Edge>[] graph;
    static List<Edge>[] reverseGraph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, time));
            reverseGraph[end].add(new Edge(start, time));
        }

        int[] distFromX = dijkstra(X, graph);
        int[] distToX = dijkstra(X, reverseGraph);

        int maxTime = 0;

        for (int i = 1; i <= N; i++) {
            int totalTime = distToX[i] + distFromX[i];
            if (totalTime > maxTime) {
                maxTime = totalTime;
            }
        }

        System.out.println(maxTime);
    }

    public static int[] dijkstra(int start, List<Edge>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.vertex;
            int curDist = current.distance;

            if (dist[curNode] < curDist) {
                continue;
            }

            for (Edge edge : graph[curNode]) {
                int nextNode = edge.to;
                int cost = dist[curNode] + edge.weight;

                if (dist[nextNode] > cost) {
                    dist[nextNode] = cost;
                    pq.offer(new Node(nextNode, cost));
                }
            }
        }

        return dist;
    }
}

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int distance;

    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    // 거리가 짧은 순으로 정렬
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }
}
