package algorithm_ex.stack_queue;

import java.util.*;

public class BraceCheck {

    public static boolean braceCheck(String braces) {
        Stack<Character> stack = new Stack<>();
        char[] ba = braces.toCharArray();
        for (Character c : ba) {
            //여는 괄호라면 스택에 넣는다.
            if (c == '(') {
                stack.push(c);
            }
            //닫는 괄호라면 스택에서 하나를 팝한다.
            else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    stack.pop();
                }

            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String braces = sc.next();

        if (braceCheck(braces)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
