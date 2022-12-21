package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class GetCombination {

    static int count = 0;
    static int N,M;
    static boolean[] checked;
    //nCm 구하기
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        checked = new boolean[N];

        dfs(0,M);
        System.out.println(count);

    }

    // 1 2 3 4
    private static void dfs(int index,int left_choice) {
        if (index == N) {
            if (left_choice == 0) {
                for (int i = 0; i < checked.length; i++) {
                    if (checked[i]) {
                        System.out.print(i);
                    }
                }
                System.out.println();
                count++;
            }
            else {
                return;
            }
        }
        else if (left_choice == 0) {
            for (int i = 0; i < checked.length; i++) {
                if (checked[i]) {
                    System.out.print(i);
                }
            }
            System.out.println();
            count++;
        }
        else {

            checked[index] = true;
            dfs(index+1,left_choice-1);
            checked[index] = false;
            dfs(index+1,left_choice);


        }


    }
}
