package algorithm_ex.dynamic_prog;

import java.util.Scanner;

public class Stair {

    public static int count = 0;

    public static void dfs(int left_num) {

        if (left_num == 0) {
            count++;
        }
        else if (left_num < 0) {
            return;
        }
        else {
            dfs(left_num -1);
            dfs(left_num - 2);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_of_stairs = sc.nextInt();

        dfs(num_of_stairs);
        System.out.println(count);


    }
}
