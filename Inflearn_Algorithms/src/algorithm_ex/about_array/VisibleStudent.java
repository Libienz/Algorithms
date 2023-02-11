package algorithm_ex.about_array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisibleStudent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n명의 학생
        int[] arr = new int[n];
        int prevMax = Integer.MIN_VALUE;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > prevMax) {
                res++;
                prevMax = arr[i];
            }
        }

        System.out.println(res);


    }
}
