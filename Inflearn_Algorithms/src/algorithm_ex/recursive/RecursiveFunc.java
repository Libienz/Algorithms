package algorithm_ex.recursive;

import java.util.Scanner;
/*
자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지 출력하는 프로그램을 작성
 */
public class RecursiveFunc {

    public static void printRecursive(int num) {
        if (num == 1) {
            System.out.print(num + " ");
        } else {
            printRecursive(num - 1);
            System.out.print(num + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printRecursive(num);

    }
}
