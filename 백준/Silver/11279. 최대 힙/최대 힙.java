import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < N; i++) {
            int code = Integer.parseInt(br.readLine());
            maxHeap.operate(code, bw);
        }
        bw.flush();
    }

    private static class MaxHeap {
        private PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        public void operate(int code, BufferedWriter bw) throws IOException {
            if (code == 0 && pq.isEmpty()) {
                bw.write(String.valueOf(0));
                bw.newLine();
            } else if (code == 0) {
                bw.write(String.valueOf(pq.poll()));
                bw.newLine();
            } else {
                pq.add(code);
            }
        }
    }
}
