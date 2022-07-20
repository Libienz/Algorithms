package algorithm_ex.sorting_searching;

import java.util.Scanner;

public class BubbleSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
    public static void bubbleSort(int[] arr) {

        for (int i = 0; i<arr.length-1; i++) {
            for (int j = 0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        bubbleSort(arr);
    }
}
