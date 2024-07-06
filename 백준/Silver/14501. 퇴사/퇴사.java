import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] times;
    private static int[] pays;
    private static int maxBenefit = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        times = new int[n];
        pays = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        bw.write(String.valueOf(maxBenefit));
        bw.flush();
    }

    public static void dfs(int day, int sum) {
        if (day >= n) {
            maxBenefit = Math.max(maxBenefit, sum);
            return;
        }

        if (day + times[day] <= n) {
            dfs(day + times[day], sum + pays[day]);
        }

        dfs(day + 1, sum);
    }
}
