package algorithm_ex.recursive;

import java.util.*;

//시간 초과  -> 방문했던 곳은 방문하지 않는다!

public class FindCow {

    static boolean[] visited;

    static int cp;
    public static boolean onCoord(int p) {
        if (1 <= p && p <= 10000) {
            return true;
        }
        return false;
    }
    public static void bfs(int sp) { //사람의 시작위치를 인자로 받는 bfs 몇번 만에 소가 있는 위치로 갈 수 있는지 찾는다.
        Queue<Integer> q = new LinkedList<>();
        q.add(sp);
        visited[sp] = true;
        int level = 0;
        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {

                Integer cur = q.poll();
//                System.out.println("cur = " + cur);
//                System.out.println("level = " + level);

                if (cur == cp) {
                    System.out.println(level);
                    return;
                }


                if (onCoord(cur + 5) && !visited[cur + 5]) {
//                    System.out.println("none");
                    q.add(cur + 5);
                    visited[cur + 5] = true;
                }
                if (onCoord(cur + 1) && !visited[cur + 1]) {
//                    System.out.println("none");
                    q.add(cur + 1);
                    visited[cur + 1] = true;
                }
                if (onCoord(cur - 1) && !visited[cur - 1]) {
//                    System.out.println("none");
                    q.add(cur - 1);
                    visited[cur - 1] = true;
                }


            }
            level++;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt(); // human position
        cp = sc.nextInt(); // cow position
        visited = new boolean[10001];
        bfs(hp);

    }
}
