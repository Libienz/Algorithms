package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Scanner;

public class DecisionMV {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n개의 곡이 존재할 때
        int m = sc.nextInt(); //m개의 DVD로 만들어 판매하려 한다.

        int[] la = new int[n];
        for (int i = 0; i < n; i++) {
            la[i] = sc.nextInt(); //각 곡은 la[i]만큼 시간이 걸림 곡이 잘리면 안됨
        }

        //똑같은 용량을 가진 m개의 dvd에 노래를 모두 넣고자 했을 때 용량이 최소가 되는 dvd의 크기를 구하라
        //결정 알고리즘 : 우리가 생각하는 범위 안에 답이 반드시 있다.

        int max = 0;
        for (int num : la) {
            max += num;
        }

        int min = max / m;

//        System.out.println("max = " + max);
//        System.out.println("min = " + min);

        for (int len = min; len <= max; len++) {

            //비디오 길이가 len일 가능성 있음 dvd m개로 가능한지 체크
            int spare = m - 1;
            int curLeft = len;
            for (int sl : la) {
//                System.out.println("spare = " + spare);
//                System.out.println("curLeft = " + curLeft);
//                System.out.println("sl = " + sl);
                if (curLeft < sl) {

                    spare -= 1;
                    curLeft = len - sl;
                } else {
                    curLeft -= sl;
                }
            }
//            System.out.println("spare = " + spare);
            if (spare >= 0) {
                System.out.println(len);
                return;
            }

        }
    }

}
