package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutaion {

    static ArrayList<Integer> arr;
    static int n;
    static int m;
    static ArrayList<Integer> choiced;
    public static void dfs(int ch) {
        if (ch == m) {
            for (Integer num : choiced) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (Integer num : arr) {
                //num을 뽑는다.
                if (choiced.contains(num)) {
                    continue;
                }
                choiced.add(num);
                dfs(ch + 1);
                //num을 뽑지 않는다.
                choiced.remove((Object) num);


            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //n개의 자연수가 주어질 것
        m = sc.nextInt(); //m개를 뽑아 일렬로 나열해야 함

        arr = new ArrayList<>();
        choiced = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        dfs(0);


    }
}
