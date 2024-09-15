import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;

    private static int[] dijkstra;
    private static List<List<Integer>> dijkstraHistory = new ArrayList<>();
    private static List<Destination>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n];
        dijkstra = new int[n];
        Arrays.fill(dijkstra, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            dijkstraHistory.add(new ArrayList<>());
        }
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int destination = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            map[start].add(new Destination(destination, cost, new ArrayList<>()));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int destination = Integer.parseInt(st.nextToken()) - 1;

        calcMinCost(start, destination);
        bw.write(String.valueOf(dijkstra[destination]));
        bw.newLine();
        bw.write(String.valueOf(dijkstraHistory.get(destination).size()));
        bw.newLine();
        for (int path : dijkstraHistory.get(destination)) {
            bw.write(String.valueOf(path + 1) + " ");
        }
        bw.flush();
    }

    private static void calcMinCost(int start, int destination) {
        Queue<Destination> pq = new PriorityQueue<>();
        boolean[] checked = new boolean[n];
        pq.add(new Destination(start, 0, new ArrayList<>()));

        while (!pq.isEmpty()) {
            int size = pq.size();

            for (int i = 0; i < size; i++) {
                Destination cur = pq.poll();
                cur.addHistory(cur.destination);
                if (checked[cur.destination]) {
                    continue;
                } else {
                    checked[cur.destination] = true;
                    dijkstra[cur.destination] = cur.cost;
                    dijkstraHistory.set(cur.destination, List.copyOf(cur.history));
                }

                int st = cur.destination;
                for (Destination d : map[st]) {
                    pq.add(new Destination(d.destination, d.cost + cur.cost, copyList(cur.history)));
                }
            }
        }
    }

    private static class Destination implements Comparable<Destination> {

        int destination;
        int cost;
        List<Integer> history;

        public Destination(int destination, int cost, List<Integer> history) {
            this.destination = destination;
            this.cost = cost;
            this.history = history;
        }

        @Override
        public int compareTo(Destination o) {
            return this.cost - o.cost;
        }

        public void addHistory(int node) {
            history.add(node);
        }
    }

    public static List<Integer> copyList(List<Integer> list) {
        List<Integer> copy = new ArrayList<>();
        for (int element : list) {
            copy.add(element);
        }
        return copy;
    }
}
