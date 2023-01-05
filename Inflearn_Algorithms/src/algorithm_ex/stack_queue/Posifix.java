package algorithm_ex.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Posifix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String calc = sc.next(); //계산식
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < calc.length(); i++) {
            int c = calc.charAt(i);
            //숫자가 들어왔을 경우
            if (Character.isDigit(c)) {
                stack.push(c-48);
            }
            //계산식이 들어왔을 경우
            else {
                int sec = stack.pop();
                int first = stack.pop();
                switch (c) {
                    case '+':
                        //System.out.println("first = " + first);
                        //System.out.println("sec = " + sec);
                        stack.push(first + sec);
                        break;
                    case '-':
                        stack.push(first - sec);
                        break;
                    case '*':
                        stack.push(first * sec);
                        break;
                    case '/':
                        stack.push(first / sec);
                        break;
                    default:
                        System.out.println("NoSuch Operator");
                        break;
                }
            }
        }
        System.out.println(stack.pop());

    }
}
