import java.io.*;
import java.util.*;

public class Q1699 {

    private static int N;
    private static int[] dp /*= new int[100001]*/;
    private static ArrayList<Integer> vals = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        //제곱수의 덧셈으로 N을 만들고자 하는 문제는 동전을 가지고 N을 만들기 위해 필요한 최소 항의 개수문제와 비슷하다
        //동전의 값들이 1^2, 2^2, 3^3 ... N^(1/2)이라고 주어졌을 때를 따지면 된다.
        int sqrt = (int) Math.sqrt(N);
        for (int i = 1; i <= sqrt; i++) {
            int num = (int) Math.pow(i, 2);
            vals.add(num);
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int val : vals) {
            for (int i = val; i <= N; i++) {
                dp[i] = Math.min(dp[i], dp[i - val] + 1);
            }
        }

        bw.write(dp[N] + "");
        bw.flush();
    }
}
