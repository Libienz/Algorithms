package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class EqualSumSubset {

    static int[] set;
    static int size;
    static boolean isSumEqualSubsetExist = false;
    static boolean[] used;


    public static void dfs(int index) {
        //System.out.println("EqualSumSubset.dfs index : " + index);
        if (index == size) {
            int sum_subset1 = 0;
            int sum_subset2 = 0;
            for (int i = 0; i < size; i++) {
                if (used[i]) {
                    sum_subset1 += set[i];
                } else {
                    sum_subset2 += set[i];
                }
            }
            if (sum_subset2 == sum_subset1) {
                isSumEqualSubsetExist = true;

            }
        }
        else {
            used[index] = true;
            dfs(index + 1);
            used[index] = false;
            dfs(index + 1);

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        set = new int[size];
        used = new boolean[size];
        for (int i = 0; i < size; i++) {
            set[i] = sc.nextInt();
        }
        dfs(0);
        if (isSumEqualSubsetExist) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


}
