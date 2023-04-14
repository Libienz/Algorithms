package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        //선택정렬
        //최솟값 찾고 0번째 인덱스와 교체
        //최솟값 찾고 1번째 인덱스와 교체
        //...

        //최솟값을 size-1만큼 찾아야 함
        //루프를 마치고 나면 i번째 인덱스까지 정렬이 완료된 상태
        for (int i = 0; i < size -1; i++) {

            //최솟값 찾기
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = i; j < size; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }

            //최솟값은 min, 최솟값의 인덱스는 minIdx
            //arr[i]와 arr[minIdx] 스왑

            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
            //이로써 배열은 i번째 까지 정렬된 상태가 된다.


        }

        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
