package algorithm_ex.stack_queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Emergency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 1;
        boolean mCured = false;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            q.add(sc.nextInt());
        }

        //m이 치료될 때까지 반복
        while (!mCured) {
            //현재 보고 있는 환자의 위험도
            Integer cur = q.poll();

            //대기 순번 중 최대 위험도 환자 구하기
            int listMax = getMax(q);

            //치료 못함
            if (cur < listMax) {
                q.offer(cur);
                if (M == 0) {
                    M = q.size() - 1;
                    continue;
                }
                M--;
                continue;
            }
            //치료 함
            else {
                //치료 한게 M이라면
                if (M == 0) {
                    System.out.println(cnt);
                    return;
                } else {
                    cnt++;
                    M--;
                }
            }
        }
    }

    private static int getMax(Queue<Integer> q) {
        int max = 0;
        for (Integer num : q) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

}
