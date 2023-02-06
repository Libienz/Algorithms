package algorithm_ex.about_string;

import java.util.Scanner;

public class Compress {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        String res = "";
        char prev = '!';
        int cnt = 1;
        for (char c : chars) {
//            System.out.println("prev = " + prev);
//            System.out.println("c = " + c);
            if (prev != c) {
                if (cnt != 1) {
                    res += cnt;
                }
                cnt = 1;
                res += c;
            } else {
                cnt++;
            }
            prev = c;
        }

        if (cnt != 1) {
            System.out.println(res += cnt);
        } else {
            System.out.println(res);
        }

    }
}
