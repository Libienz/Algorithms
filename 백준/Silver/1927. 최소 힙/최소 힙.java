import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (pq.isEmpty()) {
                    bw.write(String.valueOf(0));
                    bw.newLine();
                    continue;
                }
                bw.write(String.valueOf(pq.poll()));
                bw.newLine();
                continue;
            }
            pq.add(number);
        }
        bw.flush();
    }
}