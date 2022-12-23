package algorithm_ex.about_string;

import java.util.Scanner;

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.toLowerCase();

        int lt, rt;
        lt = 0;
        rt = str.length()-1;
        while (lt < rt) {
            //인덱스의 대칭되는 자리에 같지 않은게 있으면 palindrom 아님
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
