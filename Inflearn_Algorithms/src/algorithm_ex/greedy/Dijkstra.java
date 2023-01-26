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
        int[] dis = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
            check[i] = false;
        }

        //1에서 시작. 1로 가는 비용은 0
        dis[1] = 0;
        check[0] = true;
        //다익스트라의 전제 조건: 간선의 음수 안됨 0은 상관 없음
        while (!allCheck(check)) {

            //dis 배열의 최솟값을 가지고 있는 인덱스 번호를 얻어온다
            int minDisIdx = getMinDisIdx(dis, check);
            if (dis[minDisIdx] == Integer.MAX_VALUE) {
                check[minDisIdx] = true;
                continue;
            }
            System.out.println("minDisIdx = " + minDisIdx);
            //해당 인덱스는 노드를 말함. minDisIdx노드 까지 가는 최소거리는 확정되었다.
            check[minDisIdx] = true;


            for (Edge edge : edges) {
                if (edge.getStart() == minDisIdx) {
                    int d = edge.getFinish();
                    int cd = edge.getWeight() + dis[minDisIdx]; //연결 된 곳 까지 걸리는 거리 -> cd
                    if (cd <= dis[d]) {
                        dis[d] = cd;
                    }
                }
            }
        }

        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println(i + ": " + "impossible");
                continue;
            }
            System.out.println(i + ": " + dis[i]);
        }

    }

    private static boolean allCheck(boolean[] check) {
        for (boolean b : check) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
    private static int getMinDisIdx(int[] dis, boolean[] check) {
        int minDistance = Integer.MAX_VALUE;
        int mInd = -1;
        for (int i = 1; i < dis.length; i++) {
            if (check[i]) {
                continue;
            }
            if (dis[i] <= minDistance) {
                minDistance = dis[i];
                mInd = i;
            }
        }
        return mInd;

    }

}
