package algorithm_ex.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Posifix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String exp = sc.next();
        char[] ea = exp.toCharArray();
        Stack<Integer> st = new Stack<>();
        for (char c : ea) {
            if (Character.isDigit(c)) {
//                System.out.println((int) c);
                st.push((int) c - 48);
            } else {
                int num2 = st.pop();
                int num1 = st.pop();

                if (c == '+') {
                    st.push(num1 + num2);
                } else if (c == '-') {
                    st.push(num1 - num2);
                } else if (c == '*') {
                    st.push(num1 * num2);
                } else if (c == '/') {
                    st.push(num1 / num2);
                } else {
                    System.out.println("wrong operator..");
                    return;
                }
            }
        }
        int res = st.pop();
        System.out.println(res);
    }
}
