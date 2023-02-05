package algorithm_ex.about_string;


import java.util.Scanner;

public class UpperLowerTrans {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = "";

        char[] chars = s.toCharArray();
        for (char c : chars) {
            //소문자면 -> 대문자로
            if (Character.isLowerCase(c)) {
                ans += (char)(c - 32);
            } else {
                ans += (char)(c + 32);
            }
        }

        System.out.println(ans);
    }
}
