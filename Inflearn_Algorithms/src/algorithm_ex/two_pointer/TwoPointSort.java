package algorithm_ex.two_pointer;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoPointSort {

    public static int[] twoPointSort(int[] farr, int[] sarr) {
        int f_lt = 0;
        int s_lt = 0;
        int[] res_arr = new int[farr.length+ sarr.length];
        for (int i = 0; i<res_arr.length; i++) {
            if (f_lt >= farr.length) {
                res_arr[i] = sarr[s_lt];
                s_lt++;
            }
            else if(s_lt>= sarr.length) {
                res_arr[i] = farr[f_lt];
                f_lt++;
            }
            else {
                if (farr[f_lt] <= sarr[s_lt]) {
                    res_arr[i] = farr[f_lt];
                    f_lt++;
                }
                else {
                    res_arr[i] = sarr[s_lt];
                    s_lt++;
                }
            }
        }
        return res_arr;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int farr_size; //first arr size
        farr_size = sc.nextInt();
        int[] farr = new int[farr_size];
        for (int i = 0; i<farr_size; i++) {
            farr[i] = sc.nextInt();
        }
        int sarr_size;
        sarr_size = sc.nextInt();
        int[] sarr = new int [sarr_size];
        for (int i = 0; i<sarr_size; i++) {
            sarr[i] = sc.nextInt();
        }

        int[] res_arr = twoPointSort(farr,sarr);
        for (int i = 0; i< res_arr.length; i++) {
            System.out.print(res_arr[i] + " ");
        }
    }
}
