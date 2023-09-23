import java.util.*;
import java.io.*;

public class Q2212 {

    private static int N;
    private static int K;
    private static int[] censors;
    private static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        if (N <= K) {
            bw.write("0");
            bw.flush();
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        censors = new int[N];
        dist = new int[N - 1];

        for (int i = 0; i < N; i++) {
            censors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(censors);
        for (int i = 1; i < N; i++) {
            int distance = censors[i] - censors[i - 1];
            dist[i-1] = distance;
        }
        Arrays.sort(dist);

        int res = 0;
        for (int i = 0; i < dist.length; i++) {
            res += dist[i];
        }
        for (int i = 0; i < K-1; i++) {
            res -= dist[dist.length - 1 - i];
        }
        bw.write(res + "");
        bw.flush();

    }
}
