package algorithm_ex.recursive;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pPoint = sc.nextInt(); //수직선 상 사람 위치
        int cPoint = sc.nextInt(); //수직선 상 송아지 위치

        int res = BFS(pPoint, cPoint);
        System.out.println(res);

    }

    private static int BFS(int pPoint, int cPoint) {
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.offer(pPoint);
        boolean[] visited = new boolean[10001];
        int[] mv = new int[3];
        mv[0] = 1;
        mv[1] = -1;
        mv[2] = 5;

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        visited[pPoint] = true;


        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                if (cur == cPoint) {
                    return level;
                }
                for (int move : mv) {
                    int dest = cur + move;
                    if (1 > dest || dest > 10000) {
                        continue;
                    }
                    if (visited[dest]) {
                        continue;
                    }
                    q.offer(dest);
                    visited[dest] = true; //아직 방문하지는 않았지만 큐에 들어있으니까 중복적으로 방문하지 않도록 하는 것
                }

            }
            level++;
        }

        return -999;
    }
}
