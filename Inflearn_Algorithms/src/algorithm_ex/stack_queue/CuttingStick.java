package algorithm_ex.stack_queue;

import java.io.CharArrayWriter;
import java.util.Scanner;
import java.util.Stack;


// 스택 이용해서 처리할 것임 스택에 막대들을 넣어놓는다
// ()가 같이 나올 때 스택에 들어있는 막대가 몇개인지 세자 3개라면 자르면 6개가 된다.
// 막대 하나가 끝났다 그다음에 자른다면? 조각은 곱하기 2개가 되는 것이 아니라 하나만 추가됨
// 그말인 즉슨 처음자르는 것인지 두번째 이상으로 자르는 것인지 판별 필요



public class CuttingStick {

    public static int countStick(Stack<Character> stack) {
        int cnt = 0;

        for (Character character : stack) {
            if (character == '(') {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String placeInfo = sc.next();
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < placeInfo.length(); i++) {
            //System.out.println(stack);
            char c = placeInfo.charAt(i);
            //System.out.println("res = " + res);
            if (c == '(') {
                stack.push(c);
                res++;
            } else {
                if (stack.peek() == '(') {
                    res--;
                    stack.pop();
                    stack.push('*');
                    res += countStick(stack);
                } else {
                    while (stack.pop() != '(');
                    stack.push('*');
                }
            }
        }
        //System.out.println(stack);
        System.out.println(res);

    }
}
