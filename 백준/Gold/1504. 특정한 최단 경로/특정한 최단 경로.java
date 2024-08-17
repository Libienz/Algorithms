import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static List<EndNode>[] graph;
    private static int[] distFromStart;
    private static int[] distFromMustPass1;
    private static int[] distFromMustPass2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken()) - 1;
            int endNode = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph[startNode].add(new EndNode(endNode, weight));
            graph[endNode].add(new EndNode(startNode, weight));
        }

        st = new StringTokenizer(br.readLine());
        int mustPass1 = Integer.parseInt(st.nextToken()) - 1;
        int mustPass2 = Integer.parseInt(st.nextToken()) - 1;

        distFromStart = dijkstra(0);
        distFromMustPass1 = dijkstra(mustPass1);
        distFromMustPass2 = dijkstra(mustPass2);

        // 0 -> m1 -> m2 -> d
        int cost1 = distFromStart[mustPass1] + distFromMustPass1[mustPass2] + distFromMustPass2[N - 1];
        //0 -> m2 -> m1 -> d
        int cost2 = distFromStart[mustPass2] + distFromMustPass2[mustPass1] + distFromMustPass1[N - 1];

        if (distFromStart[mustPass1] == Integer.MAX_VALUE || distFromMustPass1[mustPass2] == Integer.MAX_VALUE
                || distFromMustPass2[N - 1] == Integer.MAX_VALUE) {
            cost1 = Integer.MAX_VALUE;
        }
        if (distFromStart[mustPass2] == Integer.MAX_VALUE || distFromMustPass2[mustPass1] == Integer.MAX_VALUE
                || distFromMustPass1[N - 1] == Integer.MAX_VALUE) {
            cost2 = Integer.MAX_VALUE;
        }
        if (cost1 == Integer.MAX_VALUE && cost2 == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(Math.min(cost1, cost2)));
        }
        bw.flush();
    }

    private static int[] dijkstra(int startNode) {
        PriorityQueue<EndNode> pq = new PriorityQueue<>();
        int[] distance = new int[N];
        boolean[] checked = new boolean[N];

        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[startNode] = 0;

        pq.add(new EndNode(startNode, 0));

        while (!pq.isEmpty()) {
            EndNode current = pq.poll();
            int currentPosition = current.destination;

            if (checked[currentPosition]) {
                continue;
            }
            checked[currentPosition] = true;

            for (EndNode neighbor : graph[currentPosition]) {
                if (distance[currentPosition] + neighbor.weight < distance[neighbor.destination]) {
                    distance[neighbor.destination] = distance[currentPosition] + neighbor.weight;
                    pq.add(new EndNode(neighbor.destination, distance[neighbor.destination]));
                }
            }
        }

        return distance;
    }

    private static class EndNode implements Comparable<EndNode> {

        int destination;
        int weight;

        public EndNode(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(EndNode o) {
            return this.weight - o.weight;
        }
    }
}

