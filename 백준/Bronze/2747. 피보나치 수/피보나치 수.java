import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[46];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        int n = Integer.parseInt(br.readLine());
        for (int i = 3; i < 46; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}
