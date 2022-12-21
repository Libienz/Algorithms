package algorithm_ex.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Posifix {

    public static int calcPostfix(String str) {

        Stack<Integer> stack = new Stack<>();
        int fnum, snum;


        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));

            }
            else {
                if (ch == '+') {
                    snum = stack.pop();
                    fnum = stack.pop();

                    stack.push(fnum + snum);
                }
                else if (ch == '-') {
                    snum = stack.pop();
                    fnum = stack.pop();

                    stack.push(fnum-snum);
                }
                else if (ch == '*') {
                    snum = stack.pop();
                    fnum = stack.pop();

                    stack.push(fnum * snum);
                }
                else if (ch == '/') {
                    snum = stack.pop();
                    fnum = stack.pop();
                    stack.push(fnum/snum);
                }
                else{
                    //오류
                }

            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(calcPostfix(str));
    }
}
