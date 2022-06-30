package algorithm_ex.about_string;

import java.util.Scanner;

public class LongestWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str_arr = str.split(" ");
        int max = 0;
        String longest = "";
        for (String ostr : str_arr) {
            if (ostr.length() > max) {
                max = ostr.length();
                longest = ostr;
            }
        }

        System.out.println(longest);

    }
}
