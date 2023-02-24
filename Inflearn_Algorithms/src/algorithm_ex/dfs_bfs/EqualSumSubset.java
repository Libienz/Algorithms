package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class EqualSumSubset {

    static int size;
    static ArrayList<Integer> set;
    static ArrayList<Integer> subset1;
    static ArrayList<Integer> subset2;
    static boolean isExist = false;

    public static void dfs(int idx) {
//        System.out.println("idx = " + idx);
        if (idx >= size) {
//            System.out.println("idx = " + idx);
//            System.out.println("subset1 = " + subset1);
//            System.out.println("subset2 = " + subset2);
            int sum1 = 0;
            int sum2 = 0;
            for (Integer num : subset1) {
                sum1 += num;
            }
            for (Integer num : subset2) {
                sum2 += num;
            }
            if (sum1 == sum2) {
                isExist = true;
            }
//            System.out.println("subset1 = " + subset1);
//            System.out.println("subset2 = " + subset2);
            return;
//            System.out.println("YES");
        } else {
            int cur = set.get(idx);
            subset1.add(cur);
            dfs(idx + 1);
            subset1.remove((Object) cur);
            subset2.add(cur);
            dfs(idx + 1);
            subset2.remove((Object) cur);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        set = new ArrayList<>();
        subset1 = new ArrayList<>();
        subset2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            set.add(sc.nextInt());
        }

        dfs(0);
        if (isExist) {
            System.out.println("YES");

        } else {
            System.out.println("NO");
        }



    }
}
