import java.util.*;
import java.io.*;

public class Main {
    private static Stack<Integer> stack = new Stack<>();

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
                stack.push(num);
            } else if (op.equals("top")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(stack.peek()) + "\n");
                }
            } else if (op.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(stack.pop()) + "\n");
                }
            } else if (op.equals("size")) {
                bw.write(String.valueOf(stack.size()) + "\n");
            } else if (op.equals("empty")) {
                if (stack.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
    }

}