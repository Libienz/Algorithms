package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class PermutationWithRepeat {

    static int N,haveto_choice;
    static int[] checked;
    public static void dfs(String answer, int choiced) {

        if (choiced == haveto_choice) {
            /*for (int i = 1; i <= N; i++) {
                if (checked[i]>0) {
                    for (int j = 0; j < checked[i]; j++) {
                        System.out.print(i + " ");
                    }

                }
            }*/
            System.out.println(answer);

        }
        else {
            for (int i = 1; i < checked.length; i++) {
                checked[i]++;
                dfs(answer+i+" ",choiced + 1);
                checked[i]--;
            }
        }


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //1~N
        checked = new int[N+1];
        haveto_choice = sc.nextInt();
        dfs("",0);
    }
}
