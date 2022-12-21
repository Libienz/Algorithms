package algorithm_ex.dynamic_prog;

import java.util.Scanner;

public class StoneBridge {

    public static int count = 0;

    public static void dfs(int left) {

        if (left == 0) {
            count++;
        }
        else if (left < 0) {
            return;
        }
        else {
            dfs(left - 1);
            dfs(left - 2);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        dfs(num + 1);
        System.out.println(count);


    }
}
