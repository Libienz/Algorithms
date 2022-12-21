package algorithm_ex.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class IgnoreBrace {

    public static String ignoreBrace(String str) {

        String res = "";
        Stack<Character> brc_stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            //괄호 시작을 만났다면 해당 괄호가 끝날 때 까지 res에는 추가 안함
            //추가할 때는 스택에 남아있는게 있는지 없는지 확인하고 추가
            if (ch == '(') {
                brc_stack.push(ch);
            }
            else if (ch == ')') {
                brc_stack.pop();
            }
            else {
                if (brc_stack.isEmpty()) {
                    res += ch;
                }
                else {
                    continue;
                }
            }


        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(ignoreBrace(str));

    }
}
