package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class CoinExchange2 {

    static int[] type_arr;
    static int type_num;

    //그리디로 안되네...
    public static int getMinCountOfCoin(int exchange) {
        int count = 0;
        for (int i = type_arr.length - 1; i >= 0; i--) {
            int num = exchange/(type_arr[i]);
            count += num;
            exchange = exchange - num*type_arr[i];
        }

        return count;
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

        System.out.println(getMinCountOfCoin(need_to_exchange));


    }
}
