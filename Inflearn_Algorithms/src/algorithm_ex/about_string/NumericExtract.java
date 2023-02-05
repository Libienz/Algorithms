package algorithm_ex.about_string;

import java.util.Scanner;

public class NumericExtract {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replaceAll("[^0-9]", "");
        Integer ans = Integer.valueOf(s);
        System.out.println(ans);

    }
}
