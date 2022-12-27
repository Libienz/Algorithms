package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class ReversePrime {

    public static int reverseInt(int num) {
        int res;
        String snum = String.valueOf(num);
        StringBuilder stbd = new StringBuilder(snum);
        String sres = stbd.reverse().toString();
        res = Integer.parseInt(sres);
        return res;
    }

    public static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        for (int i = 0; i < cnt; i++) {
            int num = reverseInt(sc.nextInt());
            if (isPrime(num)) {
                System.out.print(num + " ");

            }
        }

    }
}
