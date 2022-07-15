package algorithm_ex.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class BraceCheck {

    public static boolean isProperBraces(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            }
            else {
                if(stack.size() ==0 ) return false;
                stack.pop();
            }
        }
        if (stack.size() == 0) return true; //or stack.isEmpty()
        else return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String braces = sc.next();

        if (isProperBraces(braces)) System.out.println("YES");
        else System.out.println("NO");
    }
}
