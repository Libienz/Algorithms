package algorithm_ex.two_pointer;

import java.util.Scanner;

public class ContinuousNumSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 구하라

        //n보다 작은 연속된 자연수들의 합으로 n을 구성하기 위한 모든 case를 시작숫자로 분류한다.
        int cnt = 0;
        for (int i = 1; i <= n/2; i++) {
            //i부터 연속된 자연수들을 더해가며 합이 N을 만들 수 있는지 확인한다.
            int ss = 0; //subsum
            for (int j = i; j <= n; j++) {
                ss += j;
                if (ss > n) {
                    break;
                } else if (ss == n) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
