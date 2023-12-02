import java.util.*;
import java.io.*;

public class Main {
    private static Long id = 0L;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String brackets = br.readLine();
            if (isBalancedBrackets(brackets)) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
    }

    public static boolean isBalancedBrackets(String brackets) {
        char[] cs = brackets.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : cs) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}