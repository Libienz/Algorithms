import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder stbd = new StringBuilder();

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(br.readLine());
            arr.add(number);
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> extracted = new ArrayList<>();
        int nextNumber = 1;
        for (int num : arr) {
            if (stack.contains(num)) {
                while (stack.peek() != num) {
                    stack.pop();
                    stbd.append("-\n");

                }
                stbd.append("-\n");
                stack.pop();
            } else {
                if (nextNumber > num) {
                    System.out.println("NO");
                    return;
                }
                while (nextNumber <= num) {
                    stack.push(nextNumber++);
                    stbd.append("+\n");
                }
                stbd.append("-\n");
                stack.pop();
            }
        }
        bw.write(stbd.toString().trim());
        bw.flush();
    }
}