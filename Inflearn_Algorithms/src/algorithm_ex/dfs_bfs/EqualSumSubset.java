package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class EqualSumSubset {

    static int size;
    static boolean isSameSum = false;
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> sums = new ArrayList<>();
    static ArrayList<Integer> subSet1 = new ArrayList<>();
    static ArrayList<Integer> subSet2 = new ArrayList<>();


    public static void dfs(int idx) {
        if (idx >= size) {

            for (Integer num : arr) {
                if (!subSet1.contains(num)) {
                    subSet2.add(num);
                }
            }
//            System.out.println("subSet1 = " + subSet1);
//            System.out.println("subSet2 = " + subSet2);
            int sum1 = 0;
            int sum2 = 0;
            for (Integer num : subSet1) {
                sum1 += num;
            }
            for (Integer num : subSet2) {
                sum2 += num;
            }
            if (sum1 == sum2) {
                isSameSum = true;
            }
            subSet2.clear();
            return;
        }
        //쓴다
        subSet1.add(arr.get(idx));
        dfs(idx + 1);
        //쓰지 않는다.
        subSet1.remove((Object) arr.get(idx));
        dfs(idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
        }

        dfs(0);
        if (isSameSum) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

//        System.out.println("sums = " + sums);

//        System.out.println("sums = " + sums.size());
//        System.out.println("sums = " + sums);

    }
}
