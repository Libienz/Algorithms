package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //배열 선언 및 초기화
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        //Bubble sort
        //맨 오른쪽, 즉 맨 마지막 인덱스부터 정렬시켜나가는 방식

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
