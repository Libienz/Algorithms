import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];
        Arrays.fill(dp, -1);
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 0; i < N; i++) {
            if (dp[i] == -1) {
                continue;
            }
            if (i + 3 <= N) {
                if (dp[i + 3] == -1) {
                    dp[i + 3] = dp[i] + 1;
                }
                dp[i + 3] = Math.min(dp[i + 3], dp[i] + 1);
            }
            if (i + 5 <= N) {
                if (dp[i + 5] == -1) {
                    dp[i + 5] = dp[i] + 1;
                }
                dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
            }
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();

    }

}

