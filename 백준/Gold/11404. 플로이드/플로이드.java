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

    private static int n;
    private static int m;

    private static List<Bus>[] buses;
    private static List<int[]> shortestPaths = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        buses = new List[n];

        for (int i = 0; i < n; i++) {
            buses[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int destination = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            buses[start].add(new Bus(destination, cost));
        }

        for (int i = 0; i < n; i++) {
            shortestPaths.add(shortestPathsFrom(i));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int shortestPath = shortestPaths.get(i)[j];
                if (shortestPath == Integer.MAX_VALUE) {
                    shortestPath = 0;
                }
                bw.write(String.valueOf(shortestPath) + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }

    private static int[] shortestPathsFrom(int start) {
        int[] shortest = new int[n];
        for (int i = 0; i < n; i++) {
            shortest[i] = Integer.MAX_VALUE;
        }

        boolean[] checked = new boolean[n];
        PriorityQueue<Bus> pq = new PriorityQueue<>();

        pq.add(new Bus(start, 0));
        shortest[start] = 0;

        while (!pq.isEmpty()) {
            Bus curNode = pq.poll();
            int curPosition = curNode.destination;
            int spentCost = curNode.cost;

            if (checked[curPosition]) {
                continue;
            } else {
                checked[curPosition] = true;
                shortest[curPosition] = Math.min(spentCost, shortest[curPosition]);
            }

            for (Bus bus : buses[curPosition]) {
                if (checked[bus.destination]) {
                    continue;
                }
                pq.add(new Bus(bus.destination, spentCost + bus.cost));
            }
        }

        return shortest;
    }


    private static class Bus implements Comparable<Bus> {

        int destination;
        int cost;

        public Bus(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost;
        }
    }
}

