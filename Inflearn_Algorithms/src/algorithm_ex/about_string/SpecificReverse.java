package algorithm_ex.about_string;

import java.util.Scanner;

public class SpecificReverse {

    public static void main(String[] args) {
        int lt, rt;
        char tmp;
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray(); //문자열 받아서 char의 배열로
        lt = 0;
        rt = str.length - 1;
        while (lt < rt) {
            //알파벳이 아니라면 스왑하지 않는다.
            if (!Character.isAlphabetic(str[lt])) {
                lt++;
                continue;
            } else if (!Character.isAlphabetic(str[rt])) {
                rt--;
                continue;
            }
            tmp = str[lt];
            str[lt] = str[rt];
            str[rt] = tmp;
            lt++;
            rt--;

        }
        String res = String.valueOf(str);
        System.out.println(res);

    }

}
