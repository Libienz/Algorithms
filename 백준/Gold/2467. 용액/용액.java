import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] liquors;
    private static int liquor1;
    private static int liquor2;
    private static int closestToThreshold = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        liquors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquors);
        int left = 0;
        int right = N - 1;

        while (left < right) {
            int newLiquor = liquors[left] + liquors[right];
            if (Math.abs(newLiquor) < closestToThreshold) {
                closestToThreshold = Math.abs(newLiquor);
                liquor1 = liquors[left];
                liquor2 = liquors[right];
            }
            if (newLiquor < 0) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(liquor1 + " " + liquor2);
        bw.flush();
    }

}
