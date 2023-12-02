import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while (!(str = br.readLine()).equals(".")) {
            if (isBalanced(str)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
    }

    public static boolean isBalanced(String str) {
        char[] cs = str.toCharArray();
        Stack<Character> brackets = new Stack<>();

        for (char c : cs) {
            if (c == '(' || c == '[') {
                brackets.push(c);
            }
            if (c == ')') {
                if (brackets.isEmpty()) {
                    return false;
                }
                if (brackets.pop() != '(') {
                    return false;
                }
            }
            if (c == ']') {
                if (brackets.isEmpty()) {
                    return false;
                }
                if (brackets.pop() != '[') {
                    return false;
                }
            }
        }
        if (brackets.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}