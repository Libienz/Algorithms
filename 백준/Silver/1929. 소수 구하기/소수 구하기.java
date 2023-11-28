import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] prime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prime = new int[M + 1];
        calcEras();
        for (int i = N; i <= M; i++) {
            if (prime[i] != -1) {
                bw.write(String.valueOf(i) + "\n");
            }
        }
        bw.flush();
    }

    public static void calcEras() {
        for (int i = 1; i <= Math.sqrt(M); i++) {
            if (isPrime(i)) {
                prime[i] = 1;
                for (int j = 2; i * j <= M; j++) {
                    prime[i * j] = -1;
                }
            } else {
                prime[i] = -1;
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}