import java.io.*;
import java.security.Key;
import java.util.*;

public class Q2294 {

    private static int N;
    private static int K;
    private static Set<Integer> vals;
    private static boolean[] visited = new boolean[10001];
    private static int[] dp = new int[10001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        vals = new HashSet<>();

        for (int i = 0; i < N; i++) {
            vals.add(Integer.parseInt(br.readLine()));
        }

//        int res = bfs();
//        bw.write(res + "");

        bw.write(dp() + "");
        bw.flush();

    }

    //dp 풀이
    public static int dp() {


        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int val : vals) {
            for (int i = val; i <= K; i++) {
                int prev = dp[i - val];
                if (prev == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], prev + 1);
            }
        }
        if (dp[K] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[K];
    }
    //bfs 풀이
    public static int bfs() {

        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(0);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer cur = q.poll();
                if (cur == K) {
                    return level;
                }
                for (int val : vals) {
                    int next = val + cur;
                    if (0 <= next && next <= K && !visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
