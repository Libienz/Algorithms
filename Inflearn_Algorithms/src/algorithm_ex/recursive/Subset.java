package algorithm_ex.recursive;

import java.util.ArrayList;
import java.util.Scanner;

public class Subset {

    static int[] set;
    static int n;
    static ArrayList<Integer> subSet;
    public static void dfs(int idx) {

        for (int i = idx; i <= n; i++) {
            //i를 부분집합에 포함한다.
            subSet.add(i);
            dfs(i + 1);
            //i를 부분집합에 포함하지 않는다.
            subSet.remove((Object)i);
        }
        System.out.println(subSet);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //1 - n 부분집합을 원소수가 많은 순으로 출력
        set = new int[n];
        subSet = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            set[i - 1] = i;
        }

        dfs(1);

    }
}
