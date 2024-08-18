import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[] staffs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        staffs = new int[N];
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int maxStaffTime = 0;
        for (int i = 0; i < N; i++) {
            int timeCost = Integer.parseInt(st.nextToken());
            staffs[i] = timeCost;
            maxStaffTime = Math.max(maxStaffTime, timeCost);
        }

        long start = 0;
        long end = (long) maxStaffTime * M;
        long res = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = countManufacturable(mid);
            if (count >= M) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private static long countManufacturable(long minute) {
        long count = 0L;
        for (int staffCost : staffs) {
            count += (minute / staffCost);
        }
        return count;
    }
}
