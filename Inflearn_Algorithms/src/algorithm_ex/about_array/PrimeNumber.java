package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 소수를 구하는 메서드가 필요없다
 * 제일 작은 소수를 알고 있다면 지워나가는 것이 에라스토테네스의 체 핵심
 */
public class PrimeNumber {


//    public static boolean isPrime(int num) {
//        if (num < 2) {
//            return false;
//        }
//        if (num == 2) {
//            return true;
//        }
//        for (int i = 2; i <= num / 2; i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //1부터 n까지의 소수를 모두 찾아라

        //에라스토스테네스 체
        boolean[] eras = new boolean[n + 1];

        //eras 초기화
        for (int i = 0; i < eras.length; i++) {
            eras[i] = true;
        }

        for (int i =2; i <= n; i++) {
            if (eras[i] == true) {
                for (int j = i + i; j <= n; j = j + i) {
                    eras[j] = false;
                }
            } else {
                eras[i] = false;
                continue;
            }
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (eras[i] == true) {
//                System.out.println("??");
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}