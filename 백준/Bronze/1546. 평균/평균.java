import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> scores = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores.add(score);
        }

        int max = calcMaxScore(scores);
        bw.write(calcMyAverage(max, scores) + "");
        bw.flush();
    }

    public static int calcMaxScore(List<Integer> scores) {
        int max = Integer.MIN_VALUE;

        for (int score : scores) {
            if (max < score) {
                max = score;
            }
        }

        return max;
    }

    public static double calcMyAverage(int max, List<Integer> scores) {
        double total = 0;
        for (int originalScore : scores) {
            double modifiedScore = ((double) originalScore / max) * 100;
            total += modifiedScore;
        }
        return (total / scores.size());
    }

}