import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        dp = new int[N];
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            sum += cur;
            dp[i] = sum;
            numbers.add(cur);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(sum(start, end)));
            bw.newLine();
        }
        bw.flush();
    }

    public static int sum(int start, int end) {
        if (start - 1 == 0) {
            return dp[end - 1];
        }
        return dp[end - 1] - dp[start - 2];
    }
}
