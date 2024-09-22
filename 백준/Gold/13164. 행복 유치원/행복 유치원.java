import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int K;
    private static int[] heights;
    private static int[] diffs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        heights = new int[N];
        diffs = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            heights[i] = h;
        }

        //키차이가 가장 많이나는 곳은 분리되면 좋음
        for (int i = 0; i < N - 1; i++) {
            int cur = heights[i];
            int next = heights[i + 1];
            int diff = next - cur;
            diffs[i] = diff;
        }

        Arrays.sort(diffs);
        int res = 0;
        for (int i = 0; i < diffs.length - (K-1); i++) {
//            System.out.println("diffs[i] = " + diffs[i]);
            res += diffs[i];
        }
        bw.write(res + "");
        bw.flush();

    }



}
