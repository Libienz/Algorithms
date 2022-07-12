package algorithm_ex.two_pointer;

import java.util.Scanner;

public class MaximumSales {
    public static int maxSalesInWindow(int days, int window, int[] sales_arr) {
        int res_max = 0;
        int curr_max = 0;
        for(int i = 0; i<window; i++) {
            curr_max += sales_arr[i];
            res_max = curr_max;
        }

        for (int i = 1; i<=days-window; i++) {
            curr_max = curr_max-sales_arr[i-1] + sales_arr[i+window-1];
            if (curr_max>res_max) {
                res_max = curr_max;
            }
            //System.out.printf("%d번째 인덱스부터 %d까지 인덱스를 더한 값은 %d입니다.\n",i,i+window-1,curr_max);
        }

        return res_max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();
        int window = sc.nextInt();
        int[] sales_arr = new int[days];

        for (int i = 0; i<days; i++) {
            sales_arr[i] = sc.nextInt();
        }
        System.out.println(maxSalesInWindow(days, window, sales_arr));
    }
}
