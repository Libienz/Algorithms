package algorithm_ex.recursive;

import java.util.Scanner;

public class FibNonRecursive {
    public static int[] fibo;

    public static int getFib(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= num; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[num];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        fibo = new int[num + 1];
        System.out.println(getFib(num));

    }
}
