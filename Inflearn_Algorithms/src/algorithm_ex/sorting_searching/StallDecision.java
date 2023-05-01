package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StallDecision {

    public static int count(int C, int distance, ArrayList<Integer> arr) {
        int ep = arr.get(0);
        int cnt = 1;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - ep >= distance) {
                cnt++;
                ep = arr.get(i);
            }
        }
        return cnt;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //마구간의 개수
        int C = sc.nextInt(); //말의 마리수
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);
        //두 말의 거리가 가질 수 있는 최댓 값
        //우리가 구하고자 하는 해는 lt부터 rt사이에!
        int lt = 1;
        int rt = arr.get(arr.size() - 1) - arr.get(0);
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            //System.out.println("mid = " + mid);
            if (C <= count(C, mid, arr)) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid -1;
            }
        }
        System.out.println(answer);
    }
}