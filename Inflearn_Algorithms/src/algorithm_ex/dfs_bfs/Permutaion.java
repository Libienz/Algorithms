package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class Permutaion {

    static int[] arr;
    static int size;
    static boolean[] used;
    static int need_to_choice;

    public static void dfs(int choice_count, String answer) {
        if (choice_count == need_to_choice) {
            System.out.println(answer);
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    dfs(choice_count + 1, answer + " " + arr[i]);
                    used[i] = false;
                }

            }

        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        need_to_choice = sc.nextInt();
        arr = new int[size];
        used = new boolean[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, "");
    }
}
