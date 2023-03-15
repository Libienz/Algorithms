package algorithm_ex.hashmap_treeset;

import java.util.*;

/*

현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를

각 구간별로 구하라고 했습니다.

만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면

20 12 20 10 23 17 10

각 연속 4일간의 구간의 매출종류는

첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.

두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.

세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.

네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.

N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별

7 4
20 12 20 10 23 17 10

 */
public class TypeOfSales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> sales = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sales.add(sc.nextInt());
        }

//        System.out.println("sales = " + sales);


        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i<k; i++) {
            hm.put(sales.get(i), hm.getOrDefault(sales.get(i), 0) + 1);
        }


        System.out.print(hm.size() + " ");
        //하나의 for 문으로 끝내야 함
        for (int i = 1; i < sales.size() - k + 1; i++) {
            Integer rmv = sales.get(i - 1);
            hm.put(rmv, hm.get(rmv) -1 );
            if (hm.get(rmv) <= 0) {
                hm.remove(rmv);
            }
            hm.put(sales.get(i + k - 1), hm.getOrDefault(sales.get(i + k - 1), 0) + 1);
//            System.out.println(sales.get(i + k -1 ));
//            System.out.println("set = " + hm);
            System.out.print(hm.size() + " ");
        }
    }

}
