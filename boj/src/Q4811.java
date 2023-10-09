import java.io.*;

public class Q4811 {

    private static int N; //남아있는 알약 개수
    private static int dfsCount;
    private static long[][] dp = new long[31][31];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        while (N != 0) {
//            countByDFS(0, N);
//            bw.write(dfsCount + "");
            long res = countByDP();
            bw.write(res + "");
            bw.newLine();
            N = Integer.parseInt(br.readLine());
        }

        bw.flush();
    }

    public static long countByDP() {

        for (int i = 1; i <= 30; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 30; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1];
                    continue;
                }
                dp[i][j] = dp[i - 1][j + 1] + dp[i][j - 1];
            }
        }
        return dp[N][0];
    }

    public static void countByDFS(int half, int total) {
        if (half == 0 && total == 0) {
            dfsCount++;
            return;
        }
        //반알 먹기
        if (half > 0) {
            countByDFS(half - 1, total);
        }
        //한알 쪼개 먹기
        if (total > 0) {
            countByDFS(half + 1, total - 1);
        }
    }
}
