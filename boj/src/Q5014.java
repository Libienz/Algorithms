import java.util.*;

public class Q5014 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt(); // 총 f층으로 이루어진 건물
        int s = sc.nextInt(); // 강호의 현재 위치
        int g = sc.nextInt(); // g층으로 향해야 하는 강호
        int u = sc.nextInt(); // 엘리베이터는 위로 u층을 가거나
        int d = sc.nextInt(); // 아래로 d층을 갈 수 있다.

        boolean useStair = true;

        // 강호가 g층에 도착하려면 최소 몇번의 버튼을 눌러야 하는가?

        Queue<Integer> q = new LinkedList<>(); //bfs를 위한 q
        boolean[] visited = new boolean[1000001];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        q.add(s);
        visited[s] = true;
        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                if (cur == g) {
                    System.out.println(level);
                    q.clear();
                    useStair = false;
                    break;
                } else {
                    // 방문한적 없고 범위에 포함되는 올바른 층이면 cur + u 층을 가는 경우를 따져본다
                    int dest = cur + u;
                    if (dest <= f && dest >= 1 && !visited[dest]) {
                        q.add(dest);
                        visited[dest] = true;
                    }
                    // 방문한적 없고 범위에 포함되는 올바른 층이면 cur + d 층을 가는 경우를 따져본다
                    dest = cur - d;
                    if (dest <= f && dest >= 1 && !visited[dest]) {
                        q.add(dest);
                        visited[dest] = true;
                    }

                }
            }
            level++;
        }
        if (useStair) {
            System.out.println("use the stairs");
        }
    }
}
