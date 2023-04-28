package algorithm_ex.recursive;

import java.util.Scanner;
/*
자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지 출력하는 프로그램을 작성
 */
public class RecursiveFunc {

    static int n;
    //인자를 두개 쓰든
    //전역변수를 잡든 상관없다
    //스택 프레임의 순서와 동작흐름을 이해하라
    public static void recursivePrint(int num) {

        if (num <= n) {
            System.out.print(num + " ");
            recursivePrint(num + 1);
        } else {
            //do nothing
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        recursivePrint(1);
    }
}
