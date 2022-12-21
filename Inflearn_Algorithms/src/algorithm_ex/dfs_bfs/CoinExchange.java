package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class CoinExchange {

    static int type_num,count;
    static int min = Integer.MAX_VALUE;
    static int[] type_arr;
    public static void dfs(int remain) {
        if (count > min || remain < 0) {
            return;
        }

        else if (remain == 0) {
            if (count < min) {
                min = count;
            }
        }
        else {
            for (int i = type_arr.length-1; i>=0; i--) { //아하 알겠다!!
                count++;
                dfs(remain - type_arr[i]);
                count--;
            }

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        type_num = sc.nextInt();
        type_arr = new int[type_num];
        //type_count = new int[type_num];

        for (int i = 0; i < type_num; i++) {
            type_arr[i] = sc.nextInt();
        }
        int need_to_exchange = sc.nextInt();

        dfs(need_to_exchange);

        System.out.println(min);
    }
}
