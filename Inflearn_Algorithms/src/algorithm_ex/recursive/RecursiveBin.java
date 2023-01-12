package algorithm_ex.recursive;

import java.util.Scanner;

public class RecursiveBin {

    public static void decToBin(int num) {
        //System.out.println("몫 : " + num);
        if (num == 1) {
            System.out.print(num);
            return;
        }
        if (num == 0) {
            return;
        }
        decToBin(num / 2);
        System.out.print(num % 2);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        decToBin(num);

    }
}
