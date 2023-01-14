package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class Combination {

    static int n, r;
    static int[][] mem;
    public static int combination(int n, int r) {
        //nCr = n-1Cr-1 + n-1Cr
        if (mem[n][r] != 0) {
            return mem[n][r];
        }
        if (r == 1) {
            return n;
        } else if (n == r) {
            return 1;
        }

        int res = combination(n - 1, r - 1) + combination(n - 1, r);
        mem[n][r] = res;
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        mem = new int[n + 1][r + 1];
        System.out.println(combination(n, r));
    }
}
