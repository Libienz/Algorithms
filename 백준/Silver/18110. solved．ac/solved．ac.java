import java.util.*;
import java.io.*;

public class Main {

    private static final int R = 31;
    private static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            bw.write("0");
            bw.flush();
            return;
        }

        List<Integer> evaluations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int evaluation = Integer.parseInt(br.readLine());
            evaluations.add(evaluation);
        }

        double w = (double) N * 0.15;
        long round = Math.round(w);

        Collections.sort(evaluations);
        int sum = 0;
        for (int i = (int) round; i < evaluations.size() - round; i++) {
            sum += evaluations.get(i);
        }
        long count = evaluations.size() - (round * 2);
        double average = sum / (double) count;
        bw.write(String.format("%.0f", average));
        bw.flush();
    }
}