import java.util.*;
import java.io.*;

public class Main {
    private static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            StringTokenizer st = new StringTokenizer(command);

            String op = st.nextToken();

            if (op.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (op.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if (op.equals("pop_front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.pollFirst()) + "\n");
                }
            } else if (op.equals("pop_back")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.pollLast()) + "\n");
                }
            } else if (op.equals("size")) {
                bw.write(String.valueOf(deque.size()) + "\n");
            } else if (op.equals("empty")) {
                if (deque.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (op.equals("front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.getFirst()) + "\n");
                }
            } else if (op.equals("back")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.getLast()) + "\n");
                }
            }
        }
        bw.flush();
    }

}