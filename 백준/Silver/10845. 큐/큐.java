import java.util.*;
import java.io.*;

public class Main {
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            StringTokenizer st = new StringTokenizer(command);

            String op = st.nextToken();

            if (op.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            } else if (op.equals("front")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(q.peek()) + "\n");
                }
            } else if (op.equals("pop")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(q.poll()) + "\n");
                }
            } else if (op.equals("size")) {
                bw.write(String.valueOf(q.size()) + "\n");
            } else if (op.equals("empty")) {
                if (q.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (op.equals("back")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf((int) q.toArray()[q.size() - 1]) + "\n");
                }
            } 
        }
        bw.flush();
    }

}