import java.io.*;
import java.util.*;

public class Q2293 {

    private static int N;
    private static int K;
    private static List<Integer> vals;
    private static int dp[] = new int[10001];
    private static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        vals = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            vals.add(val);
        }
        Collections.sort(vals);

        dp[0] = 1;
        for (int val : vals) {
            for (int i = val; i <= K; i++) {
                if (i - val >= 0 && dp[i - val] > 0) {
                    dp[i] += dp[i - val];
                }
            }
        }


        bw.write(dp[K] + "");
        bw.flush();

    }



}
