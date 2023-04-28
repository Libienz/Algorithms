package algorithm_ex.recursive;

import java.util.*;

public class FibRecursive {

    public static int getFib(int n) {

        if (n == 1 || n == 2) {
            return 1;
        } else {
            return getFib(n - 2) + getFib(n - 1);
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(getFib(i) + " ");
        }
    }
}
