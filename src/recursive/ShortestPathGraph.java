package recursive;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathGraph {

    static int[][] graph;
    static int[] checked;
    static int v_num;
    static int e_num;

    public static void BFS(int start) {

        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        int level = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int cur = Q.poll();
                for (int j = 1; j < v_num + 1; j++) {
                    if (graph[cur][j] == 1 && checked[j] == 0) {
                        Q.add(j);
                        checked[j] = level+1;
                    }
                }
            }
            level++;
        }
        for (int i = 2; i < checked.length; i++) {
            System.out.println(i+"번으로 가는 최소간선 수 : " + checked[i]);
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        v_num = sc.nextInt();
        e_num = sc.nextInt();

        graph = new int[v_num+1][v_num+1];
        checked = new int[v_num + 1];
        //인접 행렬
        for (int i = 0; i < e_num; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start][end] = 1;
        }
        BFS(1);

    }
}
