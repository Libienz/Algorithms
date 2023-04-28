package algorithm_ex.recursive;

import java.util.Scanner;

public class RecursiveFactorial {

    static int res = 1;
    public static int getFact(int n) {


        if (n == 1) {
            return 1;

        } else {
            return n * getFact(n - 1);
        }


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getFact(n));


    }
}
