import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int[] points;
    private static int[] sorted;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        points = new int[N];
        sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            points[i] = value;
            sorted[i] = value;
        }

        Arrays.sort(sorted);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (rankMap.containsKey(sorted[i])) {
                continue;
            }
            rankMap.put(sorted[i], rank++);
        }

        for (int number : points) {
            bw.write(String.valueOf(rankMap.get(number)));
            bw.write(" ");
        }
        bw.flush();
    }

}
