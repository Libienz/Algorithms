import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] redCost;
    private static int[] greenCost;
    private static int[] blueCost;

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        redCost = new int[N];
        greenCost = new int[N];
        blueCost = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            redCost[i] = Integer.parseInt(st.nextToken());
            greenCost[i] = Integer.parseInt(st.nextToken());
            blueCost[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N];
        dp[0][0] = redCost[0]; //0번째 집까지 빨강(0)으로 칠하는 비용은 redCost[0]
        dp[0][1] = greenCost[0]; //0번째 집까지 초록(1)으로 칠하는 비용은 greenCost[0]
        dp[0][2] = blueCost[0]; //0번째 집까지 파랑(2)으로 칠하는 비용은 blueCost[0]

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + redCost[i], dp[i - 1][2] + redCost[i]);
            dp[i][1] = Math.min(dp[i - 1][0] + greenCost[i], dp[i - 1][2] + greenCost[i]);
            dp[i][2] = Math.min(dp[i - 1][0] + blueCost[i], dp[i - 1][1] + blueCost[i]);
        }

        int minCost = Math.min(dp[N - 1][2], Math.min(dp[N - 1][0], dp[N - 1][1]));
        bw.write(String.valueOf(minCost));
        bw.flush();
    }
}
