import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int res = calcBinomialCoefficient(N, K);
        bw.write(String.valueOf(res));
        bw.flush();
    }

    public static int calcBinomialCoefficient(int n, int k) {
        if (k < 0) {
            return 0;
        }
        if (k > n) {
            return 0;
        } else {
            return calcFactorial(n) / (calcFactorial(k) * calcFactorial(n - k));
        }
    }

    public static int calcFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calcFactorial(n - 1);
    }
}