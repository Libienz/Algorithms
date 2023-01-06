package algorithm_ex.stack_queue;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String essential = sc.next();
        String schedule = sc.next();

        int preIdx = -999;

        char[] essentialArr = essential.toCharArray();
        for (char c : essentialArr) {
            int curIdx = schedule.indexOf(c);
            if (preIdx >= curIdx || curIdx == -1) {
                System.out.println("NO");
                return;
            }
//            System.out.println("preIdx = " + preIdx);
//            System.out.println("curIdx = " + curIdx);
            preIdx = curIdx;
        }
        System.out.println("YES");
    }
}
