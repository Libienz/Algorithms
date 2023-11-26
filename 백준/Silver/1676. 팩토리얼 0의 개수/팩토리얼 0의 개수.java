import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        int fiveCount = 0;
        int twoCount = 0;
        for (int i = 1; i <= N; i++) {
            int cur = i;
            if (cur % 5 == 0) {
                fiveCount++;
                cur /= 5;
                while (cur % 5 == 0) {
                    cur /= 5;
                    fiveCount++;
                }
            }
            cur = i;
            if (i % 2 == 0) {
                twoCount++;
                cur /= 2;
                while (cur % 2 == 0) {
                    cur /= 2;
                    twoCount++;
                }
            }
        }

        bw.write(String.valueOf(Math.min(fiveCount, twoCount)));
        bw.flush();
    }


}

