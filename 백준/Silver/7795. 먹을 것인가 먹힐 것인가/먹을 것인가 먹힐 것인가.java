import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int predatorCount = Integer.parseInt(st.nextToken());
            int preyCount = Integer.parseInt(st.nextToken());

            int[] predators = new int[predatorCount];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < predatorCount; j++) {
                predators[j] = Integer.parseInt(st.nextToken());
            }

            int[] preys = new int[preyCount];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < preyCount; j++) {
                preys[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(predators);
            Arrays.sort(preys);

            int res = 0;
            for (int preySize : preys) {
                res += predatorCount(predators, preySize);
            }
            bw.write(String.valueOf(res));
            bw.newLine();
            bw.flush();
        }
    }

    public static int predatorCount(int[] predators, int preySize) {
        int start = 0;
        int end = predators.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (predators[mid] > preySize) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return predators.length - start;
    }
}
