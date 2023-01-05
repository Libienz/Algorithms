package algorithm_ex.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class BraceCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String braces = sc.next();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < braces.length(); i++) {
            if (braces.charAt(i) == '(') {
                stack.push('(');
            }
            else {
                if (stack.empty()) {
                    System.out.println("NO");
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
