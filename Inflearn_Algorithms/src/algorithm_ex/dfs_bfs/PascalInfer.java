package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalInfer {

    static int n, top;
    static ArrayList<Integer> arr;
    static ArrayList<ArrayList<Integer>> pl;
    static boolean gotAnswer = false;

    public static void dfs(int ch) {
//        System.out.println("PascalInfer.dfs");
        if (gotAnswer) {
            return;
        }
        if (ch == n) {
//            System.out.println("arr = " + arr);
            if (isPossible(arr)) {
//                System.out.println("arr = " + arr);
                pl.add((ArrayList<Integer>) arr.clone());
                gotAnswer = true;
                return;
            }
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (arr.contains(i)) {
                    continue;
                } else {
                    arr.add(i);
                    dfs(ch + 1);
                    arr.remove((Object) i);
                }
            }
        }
    }

    public static boolean isPossible(ArrayList<Integer> arr) {
//        System.out.println("PascalInfer.isPossible");
        ArrayList<Integer> tArr;
        tArr = (ArrayList<Integer>) arr.clone();

        while (tArr.size() != 1) {
            for (int i = 0; i < tArr.size() - 1; i++) {
                int num = tArr.get(0) + tArr.get(1);
                tArr.add(num);
                tArr.remove(0);
            }
            tArr.remove(0);
        }
        Integer res = tArr.get(0);
        if (res == top) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        top = sc.nextInt();
        arr = new ArrayList<>();
        pl = new ArrayList<>();
        dfs(0);
        ArrayList<Integer> res = pl.get(0);
        for (Integer num : res) {
            System.out.print(num + " ");
        }

    }
}


