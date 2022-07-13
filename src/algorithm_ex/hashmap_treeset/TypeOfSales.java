package algorithm_ex.hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TypeOfSales {

    public static void solution(int days, int win, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<win; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        //처음 4개 done
        System.out.print(map.size() + " ");

        for (int i= 1; i<=days-win; i++) {
            int lt = i-1; //빼야하는 애
            int rt = lt+win; //더해야 하는 애
            if(map.get(arr[lt]) -1 == 0) {
                map.remove(arr[lt]);
            }
            else{
                map.put(arr[lt],map.get(arr[lt])-1);
            }
            map.put(arr[rt],map.getOrDefault(arr[rt],0) + 1);
            System.out.print(map.size() + " ");
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
