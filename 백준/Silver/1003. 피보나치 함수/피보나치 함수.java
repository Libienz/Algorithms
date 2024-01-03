import java.io.*;
import java.util.*;

public class Main {

    private static int[] zeroCounts = new int[41];
    private static int[] oneCounts = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        zeroCounts[0] = 1;
        zeroCounts[1] = 0;
        oneCounts[0] = 0;
        oneCounts[1] = 1;
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 2; j <= num; j++) {
                zeroCounts[j] = zeroCounts[j - 2] + zeroCounts[j - 1];
                oneCounts[j] = oneCounts[j - 2] + oneCounts[j - 1];
            }

            bw.write(String.format("%d %d\n", zeroCounts[num], oneCounts[num]));
        }

        bw.flush();
    }
}