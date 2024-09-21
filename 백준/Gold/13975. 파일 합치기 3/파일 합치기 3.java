import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long totalCost = 0;
            while (pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();

                long mergeCost = first + second;
                totalCost += mergeCost;

                pq.add(mergeCost);
            }

            bw.write(String.valueOf(totalCost));
            bw.newLine();
        }
        bw.flush();
    }
}