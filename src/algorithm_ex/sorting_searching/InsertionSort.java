package algorithm_ex.sorting_searching;

import java.util.Scanner;

public class InsertionSort {

    public static void insertion(int[]arr,int to_ind, int from_ind) {

        int tmp = arr[to_ind];
        arr[to_ind] = arr[from_ind];
        for (int i = from_ind; i>to_ind; i--) {
            arr[i] = arr[i-1];

        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i<arr.length; i++) {
            int tmp = arr[i],j;
            for (j = i-1; j>=0; j--) {
                if (arr[j] < tmp) {
                    break;
                }
                else {
                    arr[j+1] = arr[j];
                }

            }
            arr[j+1] = tmp;




        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSort(arr);
        for (int i = 0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
