import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = br.readLine();
        String explode = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (char c : sentence.toCharArray()) {
            stack.add(c);
            if (stack.size() < explode.length()) {
                continue;
            }
            if (stackTopStringMatchesExplode(stack, explode)) {
                for (int i = 0; i < explode.length(); i++) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("FRULA");
        } else {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < stack.size(); i++) {
                res.append(stack.get(i));
            }
            bw.write(res.toString());
        }
        bw.flush();
    }

    private static boolean stackTopStringMatchesExplode(Stack<Character> stack, String explode) {

        for (int i = 0; i < explode.length(); i++) {
            if (stack.get(stack.size() - explode.length() + i) != explode.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

