package algorithm_ex.two_pointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwoPointSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //첫번째 배열의 길이를 받는다.
        int n1 = sc.nextInt();

        //배열 선언
        ArrayList<Integer> arr1 = new ArrayList<>();

        //배열 초기화
        for (int i = 0; i < n1; i++) {
            arr1.add(sc.nextInt());
        }

        //두번째 배열의 길이를 받는다.
        int n2 = sc.nextInt();

        //배열 선언
        ArrayList<Integer> arr2 = new ArrayList<>();

        //배열 초기화
        for (int i = 0; i < n2; i++) {
            arr2.add(sc.nextInt());
        }

        //두배열을 합쳐 정렬할 새로운 배열을 선언한다.
        ArrayList<Integer> res = new ArrayList<>();

        //two pointer해결을 위한 변수 선언
        int lt = 0, rt = 0;

        //two pointer 알고리즘 두 배열의 수를 비교해나가며 res 배열에 붙인다
        //한쪽 배열의 포인터가 끝까지 갔다면 남은 부분을 res배열에 이어 붙인다
        while (lt < n1 && rt < n2) {
            Integer lnum = arr1.get(lt);
            Integer rnum = arr2.get(rt);

//            System.out.println("rnum = " + rnum);
//            System.out.println("lnum = " + lnum);
            if (lnum > rnum) {
                res.add(rnum);
                rt++;
            } else {
                res.add(lnum);
                lt++;
            }
        }

//        System.out.println("res = " + res);
//        System.out.println("lt = " + lt);
//        System.out.println("rt = " + rt);
        for (int i = lt; i < n1; i++) {
            res.add(arr1.get(lt));
        }
        for (int i = rt; i < n2; i++) {
            res.add(arr2.get(i));
        }


        for (Integer i : res) {
            System.out.print(i + " ");
        }
//        System.out.println(res);







    }
}
