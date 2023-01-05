package algorithm_ex.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class IgnoreBrace {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')') {
                if (stack.contains('(')) {
                    while (stack.pop() != '(');
                    continue;
                }
            }
            stack.push(c);

        }
        for (Character character : stack) {
            System.out.print(character);

        }

    }
}
