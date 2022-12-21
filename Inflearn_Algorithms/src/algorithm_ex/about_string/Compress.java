package algorithm_ex.about_string;

import java.util.Scanner;

public class Compress {
    public static void compress(String str) {
        char prev_ch = str.charAt(0);
        int count = 1;
        System.out.print(str.charAt(0));
        for (int i = 1; i<str.length(); i++) {
            if(str.charAt(i) == prev_ch) {
                count++;
            }
            else {
                if(1<count) {
                    System.out.print(count);
                }
                prev_ch = str.charAt(i);
                System.out.print(prev_ch);
                count = 1;
            }

        }
        if(1<count) System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        compress(str);
    }
}
