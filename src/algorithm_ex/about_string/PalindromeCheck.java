package algorithm_ex.about_string;

import java.util.Locale;
import java.util.Scanner;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        String org_str = str.toLowerCase(Locale.ROOT);
        String reverse_word = reverse(str).toLowerCase(Locale.ROOT);
        if(org_str.equals(reverse_word)) {
            return true;
        }
        else {
            return false;
        }
    }
    public static String reverse(String str) {
        int lt = 0;
        int rt = str.length()-1;
        char temp;
        char[] ch_arr = str.toCharArray();
        while(lt<rt) {
           temp = ch_arr[lt];
           ch_arr[lt] = ch_arr[rt];
           ch_arr[rt] = temp;
           lt++;
           rt--;
        }
        return String.valueOf(ch_arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original_str = sc.next();
        if (PalindromeCheck.isPalindrome(original_str)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }
}
