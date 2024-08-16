import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> snacks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int snack = Integer.parseInt(st.nextToken());
            snacks.add(snack);
        }

        int start = 1;
        int end = 1000000000;
        int res = 0;
        while (start <= end) {
            int mid = ((start + end) / 2);

            int snackCount = countManufacturable(mid);
            if (snackCount >= M) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

    public static int countManufacturable(int length) {
        int sum = 0;
        for (int snack : snacks) {
            sum += (snack / length);
        }
        return sum;
    }
}

