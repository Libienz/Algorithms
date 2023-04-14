package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        //Selection sort
        //2번째 원소부터 시작 그 이전은 정렬된 상태로 보는 것 2번째 원소를 적절한 곳에 삽입
        for (int i = 1; i < size; i++) {
            // arr[i]를 왼쪽에 정렬된 부분에 삽입시킬건데 어디에 넣을 지 정해야 함
            for (int j = i; j >= 1; j--) {
                //arr[i]가 더 작으면 스왑
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
