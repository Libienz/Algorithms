package algorithm_ex.about_string;

import java.util.Scanner;

public class ReverseWord {

    public static String reverseWord(String str) {
        StringBuilder stbd = new StringBuilder(str);
        return stbd.reverse().toString();
    }
/*        char[] ch_arr = str.toCharArray();
        char[] obj_arr = new char[ch_arr.length];
        for (int i= ch_arr.length-1, j = 0; i>=0; i--, j++) {
            obj_arr[j] = ch_arr[i];
        }
        return obj_arr;
    }*/
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
