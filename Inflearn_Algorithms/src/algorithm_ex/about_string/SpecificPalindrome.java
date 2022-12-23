package algorithm_ex.about_string;

import java.util.ArrayList;
import java.util.Scanner;

public class SpecificPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toLowerCase().replaceAll("[^a-z]", ""); //정규식 이용!
        //System.out.println(str);

        int lt, rt;
        lt = 0;
        rt = str.length() - 1;

        //palindrome인지 체크한다.
        while (lt < rt) {
            if (str.charAt(lt) != str.charAt(rt)) {
                System.out.println("NO");
                return;
            }
            lt++;
            rt--;
        }
        System.out.println("YES");
    }
}
