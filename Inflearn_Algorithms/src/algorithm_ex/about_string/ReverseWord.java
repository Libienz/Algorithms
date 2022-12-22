package algorithm_ex.about_string;

import jdk.jshell.Snippet;

import java.util.Scanner;


public class ReverseWord {

    public static String reverseWord(String str) {
        //String Builder를 만들면서 str을 인자로 넘김
        //String Builder의 메소드를 사용하여 문자열을 요리조리 조작할 수 있다.
        StringBuilder stbd = new StringBuilder(str);
        return stbd.reverse().toString();

    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_of_words = sc.nextInt();
        String[] str_arr = new String[num_of_words];
        String str;

        for (int i = 0; i<num_of_words; i++) {
            str_arr[i] = sc.next();
        }
        for (int i = 0; i<num_of_words; i++) {
            System.out.println(ReverseWord.reverseWord(str_arr[i]));
        }

    }
}

