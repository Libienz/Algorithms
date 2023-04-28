package algorithm_ex.recursive;

import java.util.*;


public class FibRecursive {

    static int[] memoi;
    public static int getFib(int n) {

        if (memoi[n - 1] != 0) {
            return memoi[n - 1];
        }
        if (n == 1 || n == 2) {
            memoi[n - 1] = 1;
            return 1;
        } else {
            memoi[n-1] = getFib(n - 2) + getFib(n - 1);
            return memoi[n - 1];
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memoi = new int[n];

        for (int i = 1; i <= n; i++) {
            System.out.print(getFib(i) + " ");
        }
    }
}
