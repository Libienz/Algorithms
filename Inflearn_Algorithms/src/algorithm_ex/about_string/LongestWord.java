package algorithm_ex.about_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ml = Integer.MIN_VALUE;
        String ans = "";

        String[] strs = s.split(" ");
//        System.out.println("strs = " + strs);

        for (String str : strs) {
//            System.out.println("str = " + str);
            if (str.length() > ml) {
                ml = str.length();
                ans = str;
            }
        }

        System.out.println(ans);
    }
}
