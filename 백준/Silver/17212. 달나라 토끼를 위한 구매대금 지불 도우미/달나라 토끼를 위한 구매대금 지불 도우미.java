import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int change = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;

        for (int i = 8; i <= change; i++) {
            dp[i] = min(
                    dp[i - 1] + 1,
                    dp[i - 2] + 1,
                    dp[i - 5] + 1,
                    dp[i - 7] + 1
            );
        }

        bw.write(String.valueOf(dp[change]));
        bw.flush();
    }

    public static int min(int a, int b, int c, int d) {
        int subMin1 = Math.min(a, b);
        int sumMin2 = Math.min(c, d);

        return Math.min(subMin1, sumMin2);
    }
}
