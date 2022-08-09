package algorithm_ex.recursive;

import java.util.ArrayList;
import java.util.Scanner;

public class Navigate2 {

    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static int count = 0;

    public static void DFS(int start) {
        if (start == 5) {
            count++;
        }
        else {
            System.out.println("graph = " + graph.get(start).size());
            for (int i = 0; i < graph.get(start).size(); i++) {
                int can_go = graph.get(start).get(i); //갈 수 있는 곳
                System.out.println("can_go = " + can_go);
                if (!visited[can_go]) {
                    visited[can_go] = true;
                    DFS(can_go);
                    visited[can_go] = false;
                }
            }
        }


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int v_num = sc.nextInt();
        int e_num = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i < v_num + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[v_num + 1];
        visited[1] = true;
        //인접 리스트 만들기 완료
        for (int i = 0; i < e_num; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph.get(start).add(end);
        }

        DFS(1);

        System.out.println("count = " + count);


    }
}
