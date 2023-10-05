import java.io.*;
import java.util.*;

public class Q1904 {

    private static int N;
    private static long[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        dp = new long[1000000];

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 3L;

        for (int i = 4; i < N + 1; i++) {
            dp[i] = (((dp[i - 1] * 2) + (dp[i - 2] * 2)) / 2) % 15746;
        }

        bw.write(dp[N]+ "");
        bw.flush();
    }
}
