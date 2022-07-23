package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tricker {

    public static void findTrick(int num, int[] arr) {

        int[] trickers = new int[2];
        int tricker_val = 0;
        int tricker_ind = -1;
        int count = 0;
        for (int i = 0; i<num-1; i++) {
            if (arr[i] > arr[i+1]) { //왼쪽값이 더 큼 i혹은 i+1이 원래의 자리가 아님
                if (i==0) {
                    trickers[0] = i+1;
                    tricker_val = arr[0];
                    tricker_ind = 0;
                }
                else if (i == num-2) {
                    if (arr[i+1]>=arr[i-1] && arr[i] >= arr[i-1]) {
                        System.out.print(i+ " " + i+1);
                    }
                    else if (arr[i+1] >= arr[i-1]) {

                        trickers[count] = i + 1;
                        tricker_val = arr[i];
                        tricker_ind = i;
                    }
                    else {
                        trickers[count] = i + 2;
                        tricker_val = arr[i+1];
                        tricker_ind = i+1;
                    }
                }
                else if (arr[i-1] <= arr[i] && arr[i] <= arr[i+2]) {
                    trickers[count] = i+2;
                    tricker_val = arr[i+1];
                    tricker_ind = i+1;
                }
                else {
                    trickers[count] = i+1;
                    tricker_val = arr[i];
                    tricker_ind = i;
                }
                count++;
            }
        }
        if (count != 2) {
            for (int i = 0; i<num; i++) {
                if (i == tricker_ind) continue;
                if (tricker_val<arr[i] ) {
                    trickers[1] = i+1;
                    break;
                }
            }
        }


        Arrays.sort(trickers);

        for (int i = 0; i<trickers.length; i++) {
            System.out.print(trickers[i] + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        findTrick(num,arr);
    }
}
