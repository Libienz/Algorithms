import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] tree = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[T + 1][W + 1];

        for (int t = 1; t <= T; t++) {
            dp[t][0] = dp[t - 1][0] + (tree[t] == 1 ? 1 : 0);
        }

        for (int t = 1; t <= T; t++) {
            for (int w = 1; w <= W; w++) {
                dp[t][w] = dp[t - 1][w] + (tree[t] == (w % 2 + 1) ? 1 : 0);

                dp[t][w] = Math.max(dp[t][w], dp[t - 1][w - 1] + (tree[t] == (w % 2 + 1) ? 1 : 0));
            }
        }

        int maxPlums = 0;
        for (int w = 0; w <= W; w++) {
            maxPlums = Math.max(maxPlums, dp[T][w]);
        }

        bw.write(maxPlums + "\n");
        bw.flush();
    }
}
