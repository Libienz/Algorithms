package algorithm_ex.recursive;

import java.util.Scanner;

public class RecursiveFactorial {

    public static int getFactorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * getFactorial(num-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = getFactorial(num);
        System.out.println(res);
    }
}
