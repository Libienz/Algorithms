import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        AbsoluteValueHeap absoluteValueHeap = new AbsoluteValueHeap();

        for (int i = 0; i < N; i++) {
            absoluteValueHeap.operate(Integer.parseInt(br.readLine()), bw);
        }

        bw.flush();
    }

    private static class AbsoluteValueHeap {
        PriorityQueue<Value> pq = new PriorityQueue<>();

        private void operate(int code, BufferedWriter bw) throws IOException {
            if (code != 0) {
                pq.add(new Value(code));
            } else if (code == 0 && !pq.isEmpty()) {
                bw.write(String.valueOf(pq.poll().number));
                bw.newLine();
            } else {
                bw.write(String.valueOf(0));
                bw.newLine();
            }
        }
    }

    private static class Value implements Comparable<Value> {
        private final int number;

        public Value(int number) {
            this.number = number;
        }

        public int abs() {
            return Math.abs(number);
        }

        @Override
        public int compareTo(Value o) {
            if (abs() > o.abs()) {
                return 1;
            }
            if (abs() < o.abs()) {
                return -1;
            }
            if (abs() == o.abs()) {
                return number - o.number;
            }
            return 0;
        }

        public int getNumber() {
            return number;
        }
    }
}
