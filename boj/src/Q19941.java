import java.util.*;
import java.io.*;

public class Q19941 {

    private static int N;
    private static int K;
    private static char[] hps;
    private static int[] order;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        hps = br.readLine().toCharArray();

        order = new int[2 * K];
        int idx = 0;
        for (int i = (-1) * K; i <= K; i++) {
            if (i != 0) {
                order[idx++] = i;
            }
        }

        //왼쪽 사람부터 자신의 위치에서 가장 왼쪽 것을 먹으면 오른쪽에 있는 사람들에게 피해를 덜 끼치면서 먹을 수 있다.
        int res = 0;
        for (int i = 0; i < hps.length; i++) {
            if (hps[i] != 'P') {
                continue;
            }
            for (int j = 0; j < order.length; j++) {
                if (i + order[j] < 0 || i + order[j] >= N) {
                    continue;
                }
                if (hps[i + order[j]] == 'H') {
                    hps[i + order[j]] = 'A';
                    res++;
                    break;
                }
            }
        }
        bw.write(res + "");
        bw.flush();

    }
}
