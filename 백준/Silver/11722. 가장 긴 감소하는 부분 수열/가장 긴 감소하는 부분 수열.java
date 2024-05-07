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

        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        List<Integer> numbers = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        dp[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                Integer prev = numbers.get(i);
                Integer post = numbers.get(j);
                int count = (prev > post) ? dp[j] + 1 : 1;
                if (count > dp[i]) {
                    dp[i] = count;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
