import java.util.*;

public class Q12851 {
    static int n;
    static int k;
    static int count = 0;
    static boolean[] visited;

    public static int bfs() {
        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Integer curP = q.poll(); //현재 술래의 위치
                visited[curP] = true;
                if (curP == k) {
                    //술래가 찾은 경우
                    ++count;
                    continue;
                }
                if (count > 0) {
                    continue;
                }
                //술래가 걸었을 경우: X-1 혹은 X+1로 이동 가능
                if (curP - 1 >= 0 && curP -1 <=100000 && !visited[curP-1]) {
//                    visited[curP - 1] = true;
                    q.offer(curP - 1);
                }
                if (curP + 1 >= 0 && curP + 1 <= 100000 && !visited[curP + 1]) {
//                    visited[curP + 1] = true;
                    q.offer(curP + 1);
                }
                //술래가 순간이동 한 경우: 2*X 위치로 이동 가능
                if (curP * 2 >= 0 && curP * 2 <= 100000 && !visited[curP * 2]) {
//                    visited[curP * 2] = true;
                    q.offer(curP * 2);
                }
            }

            if (count > 0) {
                return level;
            }
            level++;

        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 직선 상 숨바꼭질
        n = sc.nextInt(); // 술래의 위치
        k = sc.nextInt(); // 동생의 위치
        visited = new boolean[100001];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int level = bfs();
        System.out.println(level);
        System.out.println(count);


    }
}
