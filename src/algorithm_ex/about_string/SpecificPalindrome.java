package algorithm_ex.about_string;

import java.util.ArrayList;
import java.util.Scanner;

public class SpecificPalindrome {
    public static String ignoreNoneAlpha(String str) {
        char[] ch_arr = str.toCharArray();
        ArrayList<Character> obj_arr = new ArrayList<Character>();
        for (char c : ch_arr) {
            if (Character.isAlphabetic(c)) {
                obj_arr.add(c);
            }
        }
        char[] fin_arr = new char[obj_arr.size()];
        for (int i = 0; i<obj_arr.size(); i++) {
            fin_arr[i] = obj_arr.get(i);
        }
        return String.valueOf(fin_arr);
    }
    public static String reverse(String str) {

        StringBuilder strbd = new StringBuilder(str);
        return strbd.reverse().toString();

    }

    public static boolean isPalindrome(String str) {
        String rev_str = reverse(str);
        if (str.equals(rev_str)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String obj_str = ignoreNoneAlpha(str).toLowerCase();
        if(isPalindrome(obj_str)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }
}
