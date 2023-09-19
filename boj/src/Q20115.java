import java.io.*;
import java.util.*;

public class Q20115 {

    private static int N;
    private static double[] amounts;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        amounts = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            double amount = Double.parseDouble(st.nextToken());
            amounts[i] = amount;
        }

        Arrays.sort(amounts);
        //버리는 양이 최소가 되어야 함
        double total = amounts[N - 1];
        for (int i = 0; i < N - 1; i++) {
            total += amounts[i] / 2;
        }

        bw.write(total + "");
        bw.flush();

    }
}
