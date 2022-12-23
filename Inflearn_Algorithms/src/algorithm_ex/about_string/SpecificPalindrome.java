package algorithm_ex.about_string;

import java.util.ArrayList;
import java.util.Scanner;

public class SpecificPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String es = "";
        char[] chars = str.toCharArray();

        //String parsing
        //es는 특수문자를 제외한 문자열을 가지게 된다.
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(chars[i])) {
                continue;
            }
            es += chars[i];
        }

        //System.out.println(es);

        //es 전부 소문자로 만들고
        es = es.toLowerCase();

        int lt, rt;
        lt = 0;
        rt = es.length() - 1;

        //palindrome인지 체크한다.
        while (lt < rt) {
            if (es.charAt(lt) != es.charAt(rt)) {
                System.out.println("NO");
                return;
            }
            lt++;
            rt--;
        }
        System.out.println("YES");
    }
}
