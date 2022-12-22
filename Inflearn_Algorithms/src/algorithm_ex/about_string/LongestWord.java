package algorithm_ex.about_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str;
        int maxWordLength = 0;
        String maxWord = null;

        str = sc.nextLine(); //한 줄 읽어오기 엔터전까지
        String[] wordList = str.split(" "); //공백문자 기준으로 split! 다만 찍어보니 공백문자가 여러번 이어지면 그것도 다 배열에 포함 시킨다.

        for (String s : wordList) {
            //System.out.println(s);
            if (s.length() >= maxWordLength) {
                maxWordLength = s.length();
                maxWord = s;
            }
        }

        System.out.println(maxWord);

    }

}
