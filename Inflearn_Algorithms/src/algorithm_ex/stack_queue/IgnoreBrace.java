package algorithm_ex.stack_queue;

import java.util.*;

public class IgnoreBrace {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        //s 문자열 중 괄호와 괄호 안의 문자를 무시한 문자열을 출력하라

        char[] ca = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        String res = "";

        for (char c : ca) {
            if (c == '(') {
                stack.push('(');
            }
            else if (c == ')') {
                stack.pop();
            }
            else {
                if (stack.isEmpty()) {
                    res += c;
                }
                else {
                    continue;

                }
            }
        }

        System.out.println(res);
    }
}
