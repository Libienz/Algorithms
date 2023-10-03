import java.util.*;
import java.io.*;

public class Q1463 {

    private static int[] dp = new int[1000001];
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

//        int res = countHopBFS(N);
        int res = countHopDP(N);
        bw.write(res + "");
        bw.flush();

    }

    //dp 풀이
    public static int countHopDP(int N) {
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 3;
        for (int i = 6; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 6; i <= N; i++) {
            int cand = 0;
            if (i % 3 == 0) {
                cand = 1 + dp[i / 3];
                if (cand < dp[i]) {
                    dp[i] = cand;
                }
            }
            if (i % 2 == 0) {
                cand = 1 + dp[i / 2];
                if (cand < dp[i]) {
                    dp[i] = cand;
                }
            }
            cand = 1 + dp[i - 1];
            if (cand < dp[i]) {
                dp[i] = cand;
            }
        }
        return dp[N];
    }
    //bfs 풀이
    public static int countHopBFS(int N) {

        int hop = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Integer cur = q.poll();
                if (cur == 1) {
                    return hop;
                }
                int next = cur;
                if (cur % 3 == 0) {
                    next = cur / 3;
                    if (!visited[next]) {
                        q.add(next);
                    }
                }
                if (cur % 2 == 0) {
                    next = cur / 2;
                    if (!visited[next]) {
                        q.add(next);
                    }
                }
                next = cur - 1;
                if (!visited[next]) {
                    q.add(next);
                }
            }
            hop++;
        }
        return -1;
    }
}
