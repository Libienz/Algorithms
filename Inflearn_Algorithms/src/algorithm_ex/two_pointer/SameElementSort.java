package algorithm_ex.two_pointer;

import java.util.*;

public class SameElementSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //첫번째 집합의 size 받는다.
        int s1 = sc.nextInt();
        //집합 선언 및 초기화
        ArrayList<Integer> set1 = new ArrayList<>();
        for (int i = 0; i < s1; i++) {
            set1.add(sc.nextInt());
        }
        //두번째 집합의 size 받는다.
        int s2 = sc.nextInt();
        //집합 선언 및 초기화
        ArrayList<Integer> set2 = new ArrayList<>();
        for (int i = 0; i < s2; i++) {
            set2.add(sc.nextInt());
        }


        //투포인터 알고리즘 사용하기 위해 두 집합 정렬
        Collections.sort(set1);
        Collections.sort(set2);

        //투포인터 알고리즘 위한 변수 선언 및 초기화
        int lt = 0;
        int rt = 0;

        //결과를 담을 집합
        ArrayList<Integer> res = new ArrayList<>();

        //투포인터 알고리즘
        while (lt < set1.size() && rt < set2.size()) {

            Integer lnum = set1.get(lt);
            Integer rnum = set2.get(rt);

            if (lnum < rnum) {
                lt++;
            } else if (lnum > rnum) {
                rt++;
            } else {
                lt++;
                rt++;
                res.add(lnum);
            }

        }
        for (Integer num : res) {
            System.out.print(num + " ");

        }
    }
}
