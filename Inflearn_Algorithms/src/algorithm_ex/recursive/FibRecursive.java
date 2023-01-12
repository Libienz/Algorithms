package algorithm_ex.recursive;

import java.util.Scanner;

public class FibRecursive {

    public static int getFib(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return getFib(num - 1)
            +getFib(num - 2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            System.out.print(getFib(i)+" ");

        }


    }
}
