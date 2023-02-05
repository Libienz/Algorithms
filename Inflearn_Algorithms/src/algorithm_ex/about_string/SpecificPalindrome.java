package algorithm_ex.about_string;

import java.util.ArrayList;
import java.util.Scanner;

public class SpecificPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String obj = "";
        String s = sc.nextLine();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                obj += c;
            }
        }
//        System.out.println("obj = " + obj);

        StringBuilder stbd = new StringBuilder(obj);
        String rs = stbd.reverse().toString();

//        System.out.println("rs = " + rs);
//        System.out.println("obj = " + obj);
        rs = rs.toLowerCase();
        obj = obj.toLowerCase();
        if (rs.equals(obj)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
