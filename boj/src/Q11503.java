import java.util.*;
import java.io.*;

public class Q11503 {

    private static int N;
    private static int[] arr = new int[1001];
    private static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            dp[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            int curEndNum = arr[i];
            /**
             * 수열의 마지막이 num으로 끝나는 경우
             * dp[i] = 자기보다 작은놈으로 끝나는 dp[j] + 1
             */
            for (int j = 0; j < i; j++) {
                int prevEndNum = arr[j];
                if (prevEndNum < curEndNum) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        //가장 긴 수열 구하기
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write(max + "");
        bw.flush();

    }
}
