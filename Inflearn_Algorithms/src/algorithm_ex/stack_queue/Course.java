package algorithm_ex.stack_queue;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {

    public static int isInNeccessaryCourse(char c, char[] cs) {
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == c) {
                return i;
            }
        }
        return -1;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String ns = sc.next();
        String cs = sc.next();

        char[] na = ns.toCharArray();
        char[] ca = cs.toCharArray();

        int nbi = -1;
        int cnt = 0;
        for (char c : ca) {
            int temp = isInNeccessaryCourse(c, na);

            //시간표를 검사하던 도중 필수과목이 나왔다.
            if (temp != -1) {
//                System.out.println("c = " + c);
                if (nbi > temp) {
//                    System.out.println("필수 과목의 순서가 잘못됨");
                    System.out.println("NO");
                    return;
                }
                cnt++;
            }
        }

        if (cnt == ns.length()) {
            System.out.println("YES");
        }
        else {
//            System.out.println("cnt = " + cnt);
//            System.out.println("ns = " + ns.length());
//            System.out.println("필수과목이 모두 들어가지 않음 ");
            System.out.println("NO");
        }
    }
}
