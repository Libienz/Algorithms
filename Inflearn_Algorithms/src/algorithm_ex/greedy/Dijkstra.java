package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    private int finish;

    @Override
    public String toString() {
        return "Edge{" +
                "finish=" + finish +
                ", weight=" + weight +
                '}';
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

    private int weight;

    public Edge(int finish, int weight) {
        this.finish = finish;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
public class Dijkstra {

    static ArrayList<ArrayList<Edge>> graph;
    static int[] distance;
    static boolean[] visited;
    static int start = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int v_num = sc.nextInt();
        int e_num = sc.nextInt();

        //int[][] graph = new int[v_num+1][v_num+1];

        graph = new ArrayList<>();
        //인접 리스트 형식의 그래프에 가중치 까지 넣고 싶다면 이렇게 Edge 객체 넣으샴
        for (int i = 0; i < v_num + 1; i++) {
            graph.add(new ArrayList<Edge>());
        }

        //그래프 초기화
        for (int i = 0; i < e_num; i++) {
            int sv = sc.nextInt();//시작 정점
            int fv = sc.nextInt();//도착 정점
            int w = sc.nextInt();//가중치
            graph.get(sv).add(new Edge(fv,w));
        }


        dijkstra(start);

    }

    private static boolean anyLeftToGo() { //갈곳이 남았는가?

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] != Integer.MAX_VALUE && !visited[i]) {
                return true;
            }
        }
        return false;

    }
    private static int getSmallestIndex() { //현재 방문하지 않은 정점 중 거리가 가장 짧은 놈을 알려줌

        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] != Integer.MAX_VALUE && !visited[i] && distance[i] != start) {
                if (distance[i] < min) {
                    min = distance[i];
                    index = i;
                }
            }
        }
        return index;
    }
    private static void dijkstra(int start) {

        distance = new int[graph.size()];
        visited = new boolean[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        visited[start] = true;

        for (Edge e : graph.get(1)) {
            distance[e.getFinish()] = e.getWeight();
        }

        while (anyLeftToGo()) {
            int togo = getSmallestIndex();
            System.out.println(togo);

            visited[togo] = true;
            int w_to_here = distance[togo];
            for (Edge e : graph.get(togo)) {
                if (distance[e.getFinish()] > w_to_here + e.getWeight()) {
                    distance[e.getFinish()] = w_to_here + e.getWeight();
                }
            }
            System.out.println();
            for (int num : distance) {
                System.out.println("num = " + num);
            }
        }

    }

}
