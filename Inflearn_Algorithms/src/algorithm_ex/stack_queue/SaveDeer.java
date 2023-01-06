package algorithm_ex.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SaveDeer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            for (int i = 0; i < K-1; i++) {
                q.add(q.poll());
            }
            q.poll();

        }
        System.out.println(q.poll());

    }
}
