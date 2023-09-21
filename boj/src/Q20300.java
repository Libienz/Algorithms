import java.io.*;
import java.util.*;

public class Q20300 {

    private static int N;
    private static Long[] ts;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        ts = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Long t = Long.parseLong(st.nextToken());
            ts[i] = t;
        }
        Arrays.sort(ts);
        //ts중 두개씩 묶은 것 중 최대가 모든 case의 최소가 되는 것을 구하라
        if (N % 2 == 0) {
            Long max = Long.MIN_VALUE;
            for (int i = 0; i < N / 2; i++) {

                Long cur = ts[i] + ts[N - 1 - i];
                if (cur > max) {
                    max = cur;
                }
            }
            bw.write(max + "");
            bw.flush();

        } else {
            Long max = Long.MIN_VALUE;
            for (int i = 0; i < (N - 1) / 2; i++) {

                Long cur = ts[i] + ts[N - 2 - i];
                if (cur > max) {
                    max = cur;
                }
            }
            if (max < ts[N - 1]) {
                max = ts[N - 1];
            }
            bw.write(max + "");
            bw.flush();

        }
    }
}
