package algorithm_ex.about_string;

import java.util.Scanner;

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.toLowerCase();

        char[] chars = s.toCharArray();
        int lt = 0;
        int rt = s.length() - 1;
        while (lt < rt) {
            char lc = chars[lt];
            char rc = chars[rt];
//            System.out.println("rc = " + rc);
//            System.out.println("lc = " + lc);
            if (lc != rc) {
                System.out.println("NO");
                return;
            }
            lt++;
            rt--;
        }
        System.out.println("YES");
    }
}
