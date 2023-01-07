package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
        }

        //i번째 원소를 i번째 이전의 정렬된 배열 중 어디에 꽂아 넣어야 하나를 찾는다.
        for (int i = 1; i < size; i++) {
            //System.out.println("arr = " + arr);
            //cur가 자기보다 왼쪽에 정렬된 애들 중에서 방을 찾는다.
            int cur = arr.get(i);
            //System.out.println("cur = " + cur);
            //들어갈 수 있는 위치는 0부터 i중 하나
            //왼쪽 중에서 자기가 들어갈 인덱스를 찾는다.
            int idx = i;
            while (idx > 0) {
                if (cur > arr.get(idx - 1)) {
                    break; //idx에 들어갈 수 있다.
                } else {
                    arr.set(idx, arr.get(idx - 1));
                    idx--;
                }
            }
            arr.set(idx, cur);

        }

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}
