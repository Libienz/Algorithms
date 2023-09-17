import java.util.*;
import java.io.*;

import static java.util.Collections.*;

public class Q11508 {

    private static int N;
    private static List<Integer> prices = new ArrayList<>();
    private static int totalPrice;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            prices.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < 3 - (N % 3); i++) {
            prices.add(0);
        }

        sort(prices, reverseOrder());

        //N개의 유제품을 모두 사야하기에 비싼 순대로 나열 하고 2+1을 하면 비싼 금액을 할인 받을 수 있다.
        for (int i = 0; i < N; i+=3) {
            int p1 = prices.get(i);
            int p2 = prices.get(i + 1);
            totalPrice += (p1 + p2);
        }

        bw.write(totalPrice + "");
        bw.flush();
    }

}
