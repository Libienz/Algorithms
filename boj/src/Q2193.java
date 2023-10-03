import java.util.*;
import java.io.*;

public class Q2193 {


    private static long[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];
        dp[0] = 0L;
        dp[1] = 1L; //1

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        bw.write(dp[N] + "");
        bw.flush();
    }


}
