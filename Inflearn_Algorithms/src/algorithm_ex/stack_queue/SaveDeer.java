package algorithm_ex.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SaveDeer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int pn = sc.nextInt();
        int k = sc.nextInt(); //k를 외치면 제외되는 왕자

        for (int i = 1; i <= pn; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            for (int i = 0; i < k-1; i++) {
                int keep = q.poll();
                q.add(keep);
            }
            q.poll();
        }
        int gp = q.poll();

        System.out.println(gp);
    }
}
