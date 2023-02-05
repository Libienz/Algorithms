package algorithm_ex.about_string;

import java.util.Scanner;


public class FindChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        System.out.println("s = " + s);
        char c = sc.next().charAt(0);
        c = Character.toLowerCase(c);
//        System.out.println("c = " + c);

        s = s.toLowerCase();
        char[] str = s.toCharArray();
        int cnt = 0;
        for (char cIns : str) {
            if (cIns == c) {
                cnt += 1;
            }
        }

        System.out.println(cnt);

    }
}
