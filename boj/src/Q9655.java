import java.util.*;
import java.io.*;

public class Q9655 {

    private static int dp[] = new int[1001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 1;
        dp[5] = 0;

        for (int i = 6; i <= n; i++) {
            if (dp[i - 1] == 0 || dp[i - 3] == 0) {
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
