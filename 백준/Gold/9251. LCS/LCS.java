import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int[][] LCS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String arr1 = br.readLine();
        String arr2 = br.readLine();

        LCS = new int[arr1.length() + 1][arr2.length() + 1];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length() + 1; i++) {
            for (int j = 0; j < arr2.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else if (arr1.charAt(i - 1) == arr2.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }

                max = Math.max(LCS[i][j], max);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
