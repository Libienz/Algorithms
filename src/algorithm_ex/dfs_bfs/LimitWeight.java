package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class LimitWeight {

    static int lim, dog_num;
    static int[] weight_arr;
    static boolean[] on_board;
    static int max_weight = 0;

    public static void dfs(int index) {
        if (index == dog_num) {
            int sum = 0;
            for (int i = 0; i < dog_num; i++) {
                if (on_board[i]) {
                    sum += weight_arr[i];
                }
            }
            if (sum > max_weight && sum < lim) {
                max_weight = sum;
            }
        }
        else {
            on_board[index] = true;
            dfs(index + 1);
            on_board[index] = false;
            dfs(index + 1);

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        lim = sc.nextInt();
        dog_num = sc.nextInt();
        weight_arr = new int[dog_num];
        on_board = new boolean[dog_num];
        for (int i = 0; i < dog_num; i++) {
            weight_arr[i] = sc.nextInt();
        }
        dfs(0);
        System.out.println(max_weight);
    }
}
