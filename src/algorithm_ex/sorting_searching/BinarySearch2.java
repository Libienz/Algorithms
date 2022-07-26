package algorithm_ex.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch2 {

    public static int binarySearch(int[] arr, int num) {

        while(true) {
            int mid_idx = arr.length/2;

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int num = sc.nextInt();
        int[] arr = new int[size];

        for (int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, num));
    }


}
