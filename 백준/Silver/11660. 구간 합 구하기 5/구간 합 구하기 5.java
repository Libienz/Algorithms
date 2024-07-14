import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[][] grid;
    private static int[][] dp;
    private static List<SubSummationCommand> subSummationCommands = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            subSummationCommands.add(new SubSummationCommand(x1, y1, x2, y2));
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = grid[i][0];
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i][j - 1] + grid[i][j];
            }
        }

        for (SubSummationCommand ssc : subSummationCommands) {
            int res = 0;
            for (int i = ssc.x1; i <= ssc.x2; i++) {
                res += dp[i][ssc.y2] - dp[i][ssc.y1 - 1];
            }
            bw.write(String.valueOf(res));
            bw.newLine();
        }
        bw.flush();
    }

    private static class SubSummationCommand {
        int x1;
        int y1;
        int x2;
        int y2;

        public SubSummationCommand(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
