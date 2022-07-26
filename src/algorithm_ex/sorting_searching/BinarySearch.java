package algorithm_ex.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] arr,int num,int start,int end) {



        /*
        for (int n : arr) {
            System.out.println(n);
        }
        */
        int mid_idx = (start + end) / 2;
        if (arr[mid_idx] == num) return mid_idx + 1;
        else if (arr[mid_idx] > num) { // mid보다 왼쪽에 num이 있을 때
            end = mid_idx;
            return binarySearch(arr,num,start,end);
        }
        else {
            start = mid_idx;
            return binarySearch(arr,num,start,end);
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
        int start = 0;
        int end = arr.length;

        Arrays.sort(arr);
        System.out.println(binarySearch(arr,num,start,end));
    }
}
