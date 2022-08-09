package algorithm_ex.recursive;

import java.util.Scanner;

public class RecursiveFunc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        printAll(num);
    }

    public static void printAll(int num) {

        if (num == 0) {
            return;
        }
        else {
            printAll(num - 1);
            System.out.println(num);
        }

    }

    // 1번째 호출 printAll(3)
    // 2번째 호출 printAll(2)
    // 3번째 호출 printAll(1)
    // 4번째 호출 printAll(0)


}
