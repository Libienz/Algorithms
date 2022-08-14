package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class Combination {

    static int[][] memoi;

    public static int getCombination(int n, int r) {
        if (memoi[n][r] != 0) {
            return memoi[n][r];
        }
        if (n == r ) {
            memoi[n][r] = 1;
            return 1;

        } else if (n - r == 1 || r==1) {
            memoi[n][r] = n;
            return n;
        } else {
            //System.out.println("n = " + n);
            //System.out.println("r = " + r);
            return getCombination(n - 1, r - 1) + getCombination(n - 1, r);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        memoi = new int[n+1][r+1];
        System.out.println(getCombination(n, r));//nCr
    }
}
