package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class PermutationWithRepeat {

    static int n;
    static int m;
    public static ArrayList<Integer> choiced;

    public static void dfs(int ch) {

//        System.out.println("ch = " + ch);
        if (ch == m) {
//            System.out.println("choiced = " + choiced);
            for (Integer n : choiced) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {

            //i을 뽑는다.
            choiced.add(i);
            dfs(ch + 1);
            //i을 뽑지 않는다.
            choiced.remove((Object) i);
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //1부터 n까지의 숫자중
        m = sc.nextInt(); //m번 뽑는다 -> 중복 허용

        choiced = new ArrayList<>();
        dfs(0);

    }
}
