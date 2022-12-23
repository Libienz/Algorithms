package algorithm_ex.about_string;

import java.util.Scanner;

public class NumericExtract {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //0-9가 아닌 것들 전부 ""로 replace
        //정규식 이용한 것임
        //str = str.replaceAll("[^0-9]", "");
        //System.out.println(Integer.valueOf(str));

        int answer = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                answer = (answer * 10) + (c - 48);
            }
        }
        System.out.println(answer);

    }
}
