import java.io.*;
import java.util.*;

public class Main {

    private static int[][] dp;
    private static int N;
    private static int K;
    private static int weights[];
    private static int values[];
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weights = new int[N + 1];
        values = new int[N + 1];
        // dp[n][k] 는 N번째 물건까지 살펴 보았을 때 무게가 K인 배낭의 최대 가치
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            weights[i] = W;
            values[i] = V;
        }

        for (int i = 1; i <= N; i++) {
            int curW = weights[i];
            int curV = values[i];

            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - curW >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - curW] + curV);
                }
            }
        }

        bw.write(dp[N][K] + "");
        bw.flush();
        bw.flush();
    }


}
