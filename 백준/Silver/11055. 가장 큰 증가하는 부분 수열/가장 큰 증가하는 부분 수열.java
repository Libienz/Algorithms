import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        int res = lisSum();
        bw.write(String.valueOf(res));
        bw.flush();
    }

    public static int lisSum() {
        for (int i = arr.length - 2; i >= 0; i--) {
            int cur = arr[i];

            for (int j = i + 1; j < N; j++) {
                int next = arr[j];
                if (cur < next) {
                    dp[i] = Math.max(dp[i], dp[j] + cur);
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int val : dp) {
            if (max < val) {
                max = val;
            }
        }
        return max;
    }
}
