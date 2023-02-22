package algorithm_ex.two_pointer;

import java.util.ArrayList;
import java.util.Scanner;

public class ContinuousNum {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n크기의 수열이 주어졌을 때
        int m = sc.nextInt(); //수열의 부분수열 중 합이 m이 되는 경우의 수를 찾아라

        //주어진 수열을 배열에 담는다.
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        //case 분류를 부분수열의 시작위치로
        //i에서 시작하는 부분 수열 중 합이 m이 되는 수열이 있는지 체크
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int ss = 0; //subsum
            for (int j = i; j < n; j++) {
                ss += arr.get(j);
                if (ss > m) {
                    break;
                }
                if (ss == m) {
                    cnt++;
                    break;
                }

            }

        }
        System.out.println(cnt);

    }
}
