package algorithm_ex.two_pointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n일 동안의 매출 기록이 주어짐
        int n = sc.nextInt();
        //연속된 k일 동안의 최대 매출액이 얼마인지 구하자
        int k = sc.nextInt();

        //n일 동안의 매출 기록을 받아서 배열에 담는다.
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sell = sc.nextInt();
            arr.add(sell);
        }

        //0일부터 연속된 매출기록이 언제가 최대인지 찾는다.
        int sub = 0;
        int res = 0;
        for (int i = 0; i < k; i++) {
            sub += arr.get(i);
//            System.out.println("msell = " + msell);
        }
        res = sub;
        for (int i = 1; i < n - k; i++) {
//            System.out.println("sub = " + sub);
            sub -= arr.get(i - 1);
//            System.out.println("sub = " + sub);
            sub += arr.get(i + k - 1);
//            System.out.println("sub = " + sub);
//            System.out.println(arr.get(i + k -1));
            if (sub > res) {
                res = sub;
            }
        }
        System.out.println(res);
//        int maxSubSell = Integer.MIN_VALUE;
//        for (int i = 0; i < n - k; i++) {
//            int subSell = 0;
//            for (int j = i; j < i + k; j++) {
//                subSell += arr.get(j);
//            }
//            if (subSell > maxSubSell) {
//                maxSubSell = subSell;
//            }
//        }
//        System.out.println(maxSubSell);
    }
}
