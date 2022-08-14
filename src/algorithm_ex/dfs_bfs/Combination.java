package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class Combination {

    public static int getCombination(int n, int r) {
        if (n == r ) {
            return 1;
        } else if (n - r == 1 || r==1) {
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
        System.out.println(getCombination(n, r));//nCr
    }
}
