package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DupCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = sc.nextInt();
            if (arr.contains(num)) {
                System.out.println("D");
                return;
            }
            arr.add(num);
        }
        System.out.println("U");

        //배열 정렬

    }
}
