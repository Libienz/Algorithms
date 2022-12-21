package algorithm_ex.about_string;

import java.util.Scanner;

public class UpperLowerTrans {

    public String solution(String str) {
        String estr = ""; // 빈문자열
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                estr += Character.toUpperCase(c);
            }
            else {
                estr += Character.toLowerCase(c);
            }
        }
        return estr;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.next();
        UpperLowerTrans trans = new UpperLowerTrans();
        System.out.println(trans.solution(str));

    }
}
