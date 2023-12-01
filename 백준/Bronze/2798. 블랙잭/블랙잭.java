import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int card1 = cards.get(i);
                    int card2 = cards.get(j);
                    int card3 = cards.get(k);

                    int sum = card1 + card2 + card3;

                    if (sum > M) {
                        continue;
                    }

                    if (sum >= max) {
                        max = sum;
                    }
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

}

