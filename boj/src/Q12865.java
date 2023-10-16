import java.io.*;
import java.util.*;

public class Q12865 {

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
                //일단 이전 물건까지 살펴봤을 때의 값을 dp 배열에 저장한다.
                dp[i][j] = dp[i - 1][j];
                //만약 현재 물건을 담을 만한 용량을 가방이 가지고 있다면
                if (j - curW >= 0) {
                    //현재 물건을 담지 않은 것과 현재 물건을 담은 가치의 최댓값을 비교하여 dp에 저장한다.
                    //현재 물건을 담은 가치의 최댓값은 이전 물건까지 살펴본 경우 현재 물건의 w를 제외한 dp[i-1][j-curW]에 curV를 더함으로써 찾아낼 수 있다.
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - curW] + curV);
                }
            }
        }

        bw.write(dp[N][K] + "");
        bw.flush();
        bw.flush();
    }


}
