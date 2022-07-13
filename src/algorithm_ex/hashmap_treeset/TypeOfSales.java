package algorithm_ex.hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TypeOfSales {

    public static void solution(int days, int win, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i= 0; i<=days-win; i++) {
            for (int j = i; j<i+win; j++) {
                map.put(arr[j],map.getOrDefault(arr[j],0) + 1);
            }
            System.out.print(map.size() + " ");
            map.clear();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int win = sc.nextInt();
        int[] arr = new int[days];
        for (int i = 0; i<days; i++) {
                arr[i] = sc.nextInt();
        }

        solution(days,win,arr);
    }
}
