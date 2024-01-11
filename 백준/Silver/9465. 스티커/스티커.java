import java.io.*;
import java.util.*;

public class Main {

    private static int T; //Test case 개수
    private static int n; //2n = 스티커의 개수
    private static int[][] dp;
    private static int[][] stickers;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            dp = new int[2][n];
            stickers = new int[2][n];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
//                    System.out.println("stickers[" + j + "][" + k + "]=" + stickers[j][k]);
                }
            }

            int res = getMaxValue(stickers);
            bw.write(res + "");
            bw.newLine();
        }
        bw.flush();
        return;
    }

    public static int getMaxValue(int[][] stickers) {
        dp[0][0] = stickers[0][0];
        dp[1][0] = stickers[1][0];
        if (n > 1) {
            dp[0][1] = stickers[1][0] + stickers[0][1];
            dp[1][1] = stickers[0][0] + stickers[1][1];
        }
        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
