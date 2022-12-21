package algorithm_ex.recursive;

import java.util.Scanner;

public class Navigate {

    public static int[][] arr;
    public static boolean[] visited;
    public static int count = 0;
    public static void DFS(int start) {
        if (start == 5) {
            count++;
        }

        else {
            for (int i = 1; i < arr.length; i++) {
                if (arr[start][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    DFS(i);
                    visited[i] = false; //원복
                }
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int v_num = sc.nextInt();
        int edge_num = sc.nextInt();
        arr = new int[v_num+1][v_num+1];

        //인접 행렬 그래프 완성
        for (int i = 0; i < edge_num; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            arr[i1][i2] = 1;
        }

        visited = new boolean[v_num + 1];
        visited[1] = true;
        int start = 1;

        DFS(start);
        System.out.println("count = " + count);

    }
}
