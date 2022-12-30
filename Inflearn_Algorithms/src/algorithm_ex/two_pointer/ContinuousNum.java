package algorithm_ex.two_pointer;

import java.util.ArrayList;
import java.util.Scanner;

public class ContinuousNum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int objSum = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
        }


        int cnt = 0;
        //가능한 부분 수열을 구할 때 case 나누는 것을 시작 지점으로 나눈다.
        //즉 0번째 인덱스에서 시작해서 나올 수 있는 부분수열이 가능한지 따지고
        //1번째 인덱스에서 시작해서 나올 수 있는 부분수열이 가능한지 따지는 순으로 쭉쭉 나간다.
        for (int i = 0; i < size; i++) {
            int subSum = 0;
            for (int j = i; j < size; j++) {
                subSum += arr.get(j);
                if (subSum == objSum) {
                    cnt++;
                    break;
                } else if (subSum > objSum) {
                    break;
                }

            }
        }

        System.out.println(cnt);

    }
}
