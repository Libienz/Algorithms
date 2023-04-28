package algorithm_ex.recursive;

import java.util.Scanner;

public class RecursiveBin {


    static String bin = "";
    public static void decTobin(int dec) {


        int q = dec / 2;
        int r = dec % 2;
//        System.out.println("q = " + q);
//        System.out.println("r = " + r);
        if (q > 0) {
            bin += r;
            decTobin(q);
        } else {
            bin += r;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int dec = sc.nextInt();

        decTobin(dec);

        StringBuilder stbd = new StringBuilder(bin);
        StringBuilder res = stbd.reverse();
        System.out.println(res);
//        System.out.println("" + 1);
    }
}
