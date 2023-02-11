package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonachi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //총 항수

        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                System.out.print("1 ");
                continue;
            }
            fib[i] = fib[i - 1] + fib[i - 2];
            System.out.print(fib[i] + " ");
        }

    }
}
