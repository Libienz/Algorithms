import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int maxBudget = Integer.MIN_VALUE;
    private static int maxGain = Integer.MIN_VALUE;

    private static int[] budgetRequests;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        budgetRequests = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgetRequests[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int lt = 0;
        int rt = Integer.MAX_VALUE;

        for (int i = 0; i <= 1000000000; i++) {
            int gain = 0;
            for (int budgetRequest : budgetRequests) {
                if (budgetRequest > i) {
                    gain += i;
                } else {
                    gain += budgetRequest;
                }
            }
            if (gain > M) {
                break;
            }
            if (maxGain == gain) {
                break;
            }
            if (gain >= maxGain) {
                maxGain = gain;
                maxBudget = i;
            }
        }

        bw.write(String.valueOf(maxBudget));
        bw.flush();
    }
}

