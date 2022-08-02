package recursive;

import java.util.Scanner;

public class FibRecursive {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            System.out.println(getFib(i));
        }


    }

    private static int getFib(int num) {

        if (num == 1 || num == 2) return 1;
        else return getFib(num - 1) + getFib(num - 2);
    }
}
