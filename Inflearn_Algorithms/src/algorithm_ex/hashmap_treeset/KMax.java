package algorithm_ex.hashmap_treeset;

import java.util.*;

public class KMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N장의 카드 : 1~100의 자연수가 적혀 있음 (중복가능)
        int K = sc.nextInt(); //나올 수 있는 3장의 카드의 합 중 K번째로 큰 숫자를 찾아볼 것임

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }

        //arr.get(i)
        //arr.get(j)
        //arr.get(k)
        //3개를 뽑아보자
        Set<Integer> sums = new TreeSet<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    int sum = arr.get(i) + arr.get(j) + arr.get(k);
                    sums.add(sum);
                }
            }
        }
        if (sums.isEmpty()||sums.size() < K) {
            System.out.println("-1");
            return;
        }
        Object[] objects = sums.toArray();
        int maxIdx = sums.size() - 1;//제일 큰 수
        Object object = objects[maxIdx - K + 1];
        System.out.println(object);

        //System.out.println(sums.get(maxIdx - K + 1));
    }
}
