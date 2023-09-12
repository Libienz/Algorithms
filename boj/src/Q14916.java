import java.util.*;
import java.io.*;

public class Q14916 {

    private static int res = Integer.MAX_VALUE;
    private static boolean solved;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        dfs(N, 0, 0, bw);
        if (res == Integer.MAX_VALUE) {
            bw.write(-1 + "");
            bw.flush();
            return;
        }
        bw.write(res + "");
        bw.flush();

    }

    public static void dfs(int remain, int count5, int count2, BufferedWriter bw) throws IOException {

        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            if (count5 + count2 < res) {
                res = count5 + count2;
                solved = true;
            }
        } else {
            if (!solved) {
                dfs(remain - 5, count5 + 1, count2, bw);
            }

            if (!solved) {
                dfs(remain - 2, count5, count2 + 1, bw);
            }
        }
    }

    public static int bfs(int remain) {

        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(remain);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                if (cur == 0) {
                    return level;
                }
                if (cur - 5 >= 0 && !visited[cur - 5]) {
                    visited[cur - 5] = true;
                    q.add(cur - 5);
                }
                if (cur - 2 >= 0 && !visited[cur - 2]) {
                    visited[cur - 2] = true;
                    q.add(cur - 2);
                }
            }
            level++;
        }
        return -1;
    }
}
