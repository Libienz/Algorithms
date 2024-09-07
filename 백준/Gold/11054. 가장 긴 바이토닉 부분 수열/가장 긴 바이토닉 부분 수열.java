import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[] ascLength;
    private static int[] descLength;
    private static int longestLength = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        ascLength = new int[N];
        descLength = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            descLength[i] = 1;
            for (int j = i + 1; j < N; j++) {
                int cur = arr[i];
                if (arr[j] < cur) {
                    descLength[i] = Math.max(descLength[j] + 1, descLength[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            ascLength[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                int cur = arr[i];
                if (arr[j] < cur) {
                    ascLength[i] = Math.max(ascLength[j] + 1, ascLength[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int bitonicLength = descLength[i] + ascLength[i];
            longestLength = Math.max(longestLength, bitonicLength);
        }

        bw.write(String.valueOf(longestLength - 1));
        bw.flush();
    }
}

