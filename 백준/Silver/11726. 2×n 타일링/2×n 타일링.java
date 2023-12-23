import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int count;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }

        bw.write(dp[N] + "");
        bw.flush();

    }

    public static void dfs(int r, int c) {

        if (r == 2 && c == N) {
            count++;
            return;
        } else {
            int nr;
            int nc;
            //눕혀서 추가 ?? 어디에 추가!?
        }
    }
}
