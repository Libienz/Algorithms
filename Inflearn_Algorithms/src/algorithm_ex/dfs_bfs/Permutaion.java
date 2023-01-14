package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutaion {

    static int n, m;
    static ArrayList<Integer> arr;
    static ArrayList<Integer> res;
    public static void dfs(int num) {
//        System.out.println("res = " + res[0]);
        if (num == m) {
            for (int n : res) {
                System.out.print(n + " ");
            }
            System.out.println();
        } else {
            for (Integer n : arr) {
//                System.out.println("num = " + num);
                if (res.contains(n)) {
                    continue;
                } else {
                    res.add(n);
                    dfs(num + 1);
                    res.remove((Object) n);
                }

            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        res = new ArrayList<Integer>();

        dfs(0);


    }
}
