package algorithm_ex.sorting_searching;

import java.util.Scanner;

public class Faker {

    public static void findFaker(int num, int[] arr) {

        for (int i = 0; i<num-1; i++) {
            if (arr[i]>arr[i+1]) {

            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i<num; i++) {
            arr[i] = sc.nextInt();
        }
        findFaker(num,arr);
    }
}
