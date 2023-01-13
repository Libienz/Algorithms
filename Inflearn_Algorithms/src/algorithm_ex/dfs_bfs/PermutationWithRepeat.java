package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class PermutationWithRepeat {

    static int n;
    static int m;
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> choiced = new ArrayList<>();

    public static void dfs(int c) {
        //뽑아야 할 만큼 뽑았을 경우
        if (c == m) {
            System.out.println("choiced = " + choiced);
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                //i를 뽑는다.
                choiced.add(i);
                dfs(c + 1);
                //i를 뽑지 않는다.
                choiced.remove((Object) i);


            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        dfs(0);


    }
}
