package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
        }

        //select sort
        int idx = 0;
        while (idx < size) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            //idx부터 끝까지 중에서 가장 작은 놈 찾아서 idx자리에 집어넣을 것
            for (int i = idx; i < size; i++) {
                if (arr.get(i) < min) {
                    min = arr.get(i);
                    minIdx = i;
                }
            }
            Integer tmp = arr.get(idx);
            arr.set(idx, min);
            arr.set(minIdx, tmp);
            idx++;

        }
        for (Integer integer : arr) {
            System.out.print(integer+" ");
        }

    }
}
