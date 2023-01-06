package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    //swap
                    int tmp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, tmp);
                }
                //System.out.println("arr = " + arr);

            }

        }
        System.out.println(arr);

    }
}
