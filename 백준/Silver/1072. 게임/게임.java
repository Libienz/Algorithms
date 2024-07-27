import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        Long z = y * 100L / x;

        if (z >= 99) {
            bw.write(String.valueOf(-1));
            bw.flush();
            return;
        }

        int start = 1;
        int end = 1000000000;

        int mid = 0;
        int ans = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            int newX = x + mid;
            int newY = y + mid;
            Long newZ = newY * 100L / newX;

            if (newZ != z) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
