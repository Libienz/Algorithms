import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (N == calcDecomposeSum(i)) {
                res = i;
                break;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static int calcDecomposeSum(int N) {
        int decomposeSum = N;

        while (N / 10 != 0) {
            decomposeSum += N % 10;
            N /= 10;
        }
        decomposeSum += N;
        return decomposeSum;
    }
}