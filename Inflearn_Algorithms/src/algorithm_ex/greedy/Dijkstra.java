package algorithm_ex.greedy;

import java.util.*;

class Edge {
    private int start;
    private int finish;
    private int weight;

    public Edge(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public Edge(int start, int finish, int weight) {
        this.start = start;
        this.finish = finish;
        this.weight = weight;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
public class Dijkstra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(Integer.MIN_VALUE);

        for (int i = 0; i < m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            res.add(Integer.MAX_VALUE);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        res.set(1, 0);
        int hop = 0;

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer curNode = q.poll();
                for (Edge edge : edges) {
                    if (edge.getStart() == curNode) {
                        int d = edge.getFinish();
                        q.add(d);
                        //set 하기 전에 더 짧은 거리인지 체크
                        if (res.get(d) < )
                        res.set(d, res.get(d) + edge.getWeight());
                    }
                }
            }
        }
    }
}
