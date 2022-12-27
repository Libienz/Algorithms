package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;
        ArrayList<Boolean> eras = new ArrayList<>();

        //에라토스테네스 채 초기화
        eras.add(false);
        eras.add(false);
        for (int i = 2; i <= num; i++) {
            eras.add(true);
        }

        for (int i = 0; i < eras.size(); i++) {
            if (eras.get(i)) {
                //소수의 배수들은 소수가 아님 걸러낸다!
                for (int j = i*2; j <= eras.size(); j += i) {
                    eras.set(j, false);
                }
            }
        }

        for (int i = 0; i < eras.size(); i++) {
            if (eras.get(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}