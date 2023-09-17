import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Q11399 {

    private static int N;
    private static int[] time;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        time = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time/*, Comparator.reverseOrder()*/);

        int totalTime = 0;
        for (int i = 0; i < N; i++) {
            //time[i]분 걸리는 사람이 총 처리하기 까지 걸린 시간은
            int pt = 0;
            for (int j = 0; j < i; j++) {
                pt += time[j];
            }
            pt += time[i];
            totalTime += pt;
        }
        bw.write(totalTime + "");
        bw.flush();
    }
}
