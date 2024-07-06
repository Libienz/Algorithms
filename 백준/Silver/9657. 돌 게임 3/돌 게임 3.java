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

        int n = Integer.parseInt(br.readLine());
        dp = new int[1001];

        dp[1] = 0; // SK win
        dp[2] = 1; // CY win
        dp[3] = 0; // SK win
        dp[4] = 0; // SK win
        dp[5] = 0; // SK win

        for (int i = 6; i <= n; i++) {

            if (dp[i - 3] + dp[i - 4] + dp[i - 1] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }
        if (dp[n] == 0) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }
        bw.flush();
    }
}
