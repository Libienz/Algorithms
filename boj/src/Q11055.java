import java.io.*;
import java.util.*;

public class Q11055 {

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
            dp[i] = num;
        }

        dp[0] = arr[0];

        for (int i = 1; i <= N; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }

        }

//        for (int i = 0; i <= N; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= N; i++) {
            max = Math.max(dp[i], max);
        }
        bw.write(max + "");
        bw.flush();
    }

}
