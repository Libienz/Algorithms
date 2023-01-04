package algorithm_ex.hashmap_treeset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TypeOfSales {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N일간의 매출이 주어질것
        int K = sc.nextInt(); //K만큼의 window size
        ArrayList<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }

        for (int i = 0; i < K; i++) {
            int num = arr.get(i);
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        System.out.print(map.size() + " ");
        for (int i = K; i < arr.size(); i++) {
            int num = arr.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
            num = arr.get(i - K);
            if (map.get(num) == 1) {
                map.remove(num);
            }
            else {
                map.put(num, map.get(num)-1);
            }
            System.out.print(map.size() + " ");
        }

    }
}
