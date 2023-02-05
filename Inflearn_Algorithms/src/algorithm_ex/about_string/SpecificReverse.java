package algorithm_ex.about_string;

import java.util.Scanner;

public class SpecificReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        int lt = 0;
        int rt = chars.length - 1;

        while (lt < rt) {
            char lc = chars[lt];
            char rc = chars[rt];

            if (!Character.isAlphabetic(lc)) {
                lt++;
                continue;
            }
            if (!Character.isAlphabetic(rc)) {
                rt--;
                continue;
            }

            chars[lt] = chars[rt];
            chars[rt] = lc;

            lt++;
            rt--;
        }
        System.out.println(chars);
    }
}
