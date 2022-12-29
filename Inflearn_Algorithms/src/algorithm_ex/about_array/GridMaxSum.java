package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class GridMaxSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] arr = new int[size][size];
        int rMaxSum = 0;
        int rSum = 0;
        int cMaxSum = 0;
        int cSum = 0;
        int dMaxSum = 0;
        int dSum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = sc.nextInt();
                rSum+=arr[i][j];
            }
            if (rSum > rMaxSum) {
                rMaxSum = rSum;
            }
            rSum = 0;
        }
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                cSum += arr[i][j];
            }
            if (cSum > cMaxSum) {
                cMaxSum = cSum;
            }
            cSum = 0;
        }
        for (int i = 0; i < size; i++) {
            dSum += arr[i][i];
        }
        if (dSum > dMaxSum) {
            dMaxSum = dSum;
        }
        dSum = 0;
        for (int i = 0; i < size; i++) {
            dSum += arr[i][size - i - 1];
        }
        if (dSum > dMaxSum) {
            dMaxSum = dSum;
        }

        int subMax = Math.max(dMaxSum, rMaxSum);
        int res = Math.max(subMax, cMaxSum);
        System.out.println(res);
    }
}
