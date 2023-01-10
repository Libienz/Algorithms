package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int target = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        //정렬된 상태에서 이분 검색 binary search
        int lt = 0;
        int rt = size - 1;

        while (lt <= rt) {
            int midIdx = (lt + rt) / 2;
            int midNum = arr.get(midIdx);

            if (midNum == target) {
                System.out.println(midIdx+1);
                break;
            } else if (midNum < target) {
                lt = midIdx + 1;
                continue;
            } else {
                rt = midIdx - 1;
                continue;
            }
        }
    }

}
