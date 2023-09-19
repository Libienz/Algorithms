import java.util.*;
import java.io.*;

public class Q11047 {

    private static int N;
    private static int K;
    private static Integer[] cvs;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cvs = new Integer[N];
        visited = new boolean[K+1];
        for (int i = 0; i < N; i++) {
            cvs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cvs, Comparator.reverseOrder());
        int res = 0;
        for (Integer cv : cvs) {
            if (K == 0) {
                break;
            }
            if (cv <= K) {
                res += K / cv;
                K = K % cv;
//                System.out.println("K = " + K);
            }
        }

        bw.write(res + "");
        bw.flush();

    }

}
