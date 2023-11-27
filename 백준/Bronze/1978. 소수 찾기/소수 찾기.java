import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (isPrimeNumber(number)) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }

    public static boolean isPrimeNumber(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}