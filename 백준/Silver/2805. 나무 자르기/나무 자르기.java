import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] treeHeights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        treeHeights = new int[N];
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeHeights[i] = Integer.parseInt(st.nextToken());
        }

        int maxSowHeight = Integer.MIN_VALUE;
        int left = 0;
        int right = Integer.MAX_VALUE;

        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            long earned = earnedTreeLength(treeHeights, mid);
            if (earned >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        bw.write(String.valueOf(right));
        bw.flush();
    }

    private static long earnedTreeLength(int[] treeHeights, int sowHeight) {
        long earned = 0;
        for (int treeHeight : treeHeights) {
            int earn = treeHeight - sowHeight;
            if (earn > 0) {
                earned += earn;
            }
        }
        return earned;
    }
}
