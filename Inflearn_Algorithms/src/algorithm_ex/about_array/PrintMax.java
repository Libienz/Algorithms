package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n개의 정수가 입력될 것

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int prev = Integer.MIN_VALUE;
        for (Integer num : arr) {
            if (prev < num) {
                System.out.print(num + " ");
            }
            prev = num;

        }


    }
}
