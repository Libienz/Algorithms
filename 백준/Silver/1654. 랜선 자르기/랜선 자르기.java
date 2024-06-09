import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int K;
    private static int N;
    private static List<Integer> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            int length = Integer.parseInt(br.readLine());
            lines.add(length);
        }

        Long start = 1L;
        Long end = Collections.max(lines).longValue();

        while (start <= end) {

            Long mid = (start + end) / 2;
            int count = count(mid);
            if (count < N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        bw.write(String.valueOf(end));
        bw.flush();

    }

    public static int count(Long cutLength) {
        int sum = 0;
        for (int lineLength : lines) {
            sum += (lineLength / cutLength);
        }
        return sum;
    }
}

