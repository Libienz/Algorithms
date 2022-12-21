package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WonderPrim {

    static int v;
    static int e;
    public static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    public static int prim() {

        PriorityQueue<Edge> pq = new PriorityQueue();
        boolean[] checked = new boolean[v + 1];
        pq.add(new Edge(1, 0));
        int answer = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (!checked[cur.getFinish()]) { //우리가 만들고 있는 서브그래프에 포함되지 않은 노드일 때
                checked[cur.getFinish()] = true;
                answer += cur.getWeight();
                //System.out.println("answer = " + answer);
                for (Edge e : graph.get(cur.getFinish())) {
                    pq.add(e);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt(); // 도시의 개수
        e = sc.nextInt(); // 도로의 개수

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Edge>());
        }

        //그래프 초기화
        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int finish = sc.nextInt();
            int weight = sc.nextInt();
            graph.get(start).add(new Edge(finish, weight));
            graph.get(finish).add(new Edge(start, weight));
        }

        System.out.println(prim());


        //간선 가중치의 오름차순으로 정렬 CompartTo 활용



    }
}
