package algorithm_ex.about_string;

import java.util.Scanner;

public class FindChar {
    public static void main (String[] args) {

        String str;
        char c;
        int count = 0;

        Scanner sc = new Scanner(System.in);
        str = sc.next();
        c = sc.next().charAt(0);
        str = str.toLowerCase();
        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) == Character.toLowerCase(c)) {
                count++;
            }
        }

        System.out.println(count);


    }
}
