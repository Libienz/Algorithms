package algorithm_ex.stack_queue;

import java.io.CharArrayWriter;
import java.util.Scanner;
import java.util.Stack;

public class CuttingStick {


    public static void main(String[] args) {

        boolean lp = true;
        Scanner sc = new Scanner(System.in);
        String sna = sc.next(); //sticks and lazer
        char[] ca = sna.toCharArray();
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        for (char c : ca) {
            if (c == '(') {
                //쇠막대기의 시작 혹은 레이저의 시작
                cnt++;
                st.push(c);
                lp = true;

            } else {

                st.pop();
                //lazer
                if (lp) {
                    cnt--;
//                    System.out.println("lazer");
                    //레이저 아래에 있는 막대의 수: s
                    int s = st.size();
                    cnt += s;
                    lp = false;

                }
                //그냥 닫는 괄호
                else {
                    //do nothing
                    lp = false;
                }
            }
        }

        System.out.println(cnt);

    }
}
