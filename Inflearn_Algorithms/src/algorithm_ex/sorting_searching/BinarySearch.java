package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n개의 숫자가 주어진다
        int m = sc.nextInt(); //m이라는 숫자가 이분 검색 후 몇번째에 있는 지 구하시오 중복값 존재 x

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //이분 검색은 정렬된 상태에서 시작하기에 정렬 먼저
        //선택정렬
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;

            for (int j = i; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIdx = j;
                }
            }

            int tmp = arr[i];
            arr[i] = min;
            arr[minIdx] = tmp;
        }
        //arr은 정렬완료
        //binary search로 m을 찾을 것

        int lt = 0;
        int rt = n-1;

        while (lt <= rt) {
            int midIdx = (lt + rt) / 2;
            int mid = arr[midIdx];


            if (m == mid) {
                System.out.println(midIdx + 1);
                break;
            } else if (m < mid) {
                rt = midIdx - 1;
            } else {
                lt = midIdx + 1;
            }
        }



    }

}
