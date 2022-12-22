package algorithm_ex.about_string;

import java.util.Scanner;

public class UpperLowerTrans {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        //빈문자열에 붙여넣기 신공! 유용하게 쓰이는 편
        //Stirng에서는 +연산자가 오버로딩 되니까.. 빈 문자열 만들어 놓고 정답을 붙여나갈 수 있다.
        String answer = "";

        char[] chars = str.toCharArray();

        //enumertation controlled loop는 String에서 안됨
        //즉 java는 String에 for each 못씀
        //고로 str.toCharArray(); 필요!!
        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            }
            else {
                answer += Character.toLowerCase(c);
            }
        }

        System.out.println(answer);
    }
}
