package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReversePrime {

    public static int getReversedNum(int num) {

        int tnum = num;
        int res = 0;
        while (true) {

            if (tnum / 10 == 0) { //맨 앞자리수를 보고 있다는 뜻
                if (tnum % 10 == 0) { //맨 앞자리수가 0이라면 res에 10이 곱해져있는 걸 원상복구
                    res = res / 10;
                } else {
                    res += tnum % 10;
                }
                break;

            }
            res += tnum % 10;
            tnum = tnum / 10;
            res = res * 10;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //자연수의 개수

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int rnum = getReversedNum(num);
//            System.out.println("rnum = " + rnum);
            arr.add(rnum);
        }

        //arr에는 뒤집힌 수들이 들어가 있음
        //arr에 들어있는 수 중 가장 큰수를 찾자(가장 큰 수까지 배열을 만들어 에라스토스테네스의 체를 이용하기 위햬)
        int max = Integer.MIN_VALUE;
        for (Integer num : arr) {
            if (num > max) {
                max = num;
            }
        }

        ArrayList<Boolean> eras = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            eras.add(true);
        }
        eras.set(0, false);
        eras.set(1, false);

        for (int i = 2; i <= max; i++) {
            if (eras.get(i)) {
                int j = 2;
                int comp;
                while ((comp = i * (j++)) <= max) {
                    eras.set(comp, false);
                }
            }
        }

        //eras 정리 끝

        for (Integer num : arr) {
//            System.out.println("num = " + num);
            if (eras.get(num)) {
                System.out.print(num + " ");
            }
        }

//        System.out.println();
//        System.out.println("eras = " + eras);
//        System.out.println(eras.size());

    }
}
