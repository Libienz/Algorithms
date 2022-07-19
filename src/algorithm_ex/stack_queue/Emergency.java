package algorithm_ex.stack_queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Emergency {

    public static int getOrder(int num, int m, Queue<Integer> queue) {


        int count = 1;
        int m_tracer = m;

        while (true) {

            //System.out.println("현재 m_tracer : " + m_tracer+ "큐사이즈 : " + queue.size());

            int curr = queue.poll();

            //System.out.println(m_tracer);

            if (m_tracer == 0) {
                if (curr < Collections.max(queue)) { //m의 차례이지만 큐에 위험도가 더 큰 환자가 있다면
                    queue.offer(curr);
                    m_tracer = queue.size() -1; //m은 맨뒤로
                }
                else { //m의 차례이면서 자기보다 큰 환자가 없어서 당선

                    return count;
                }
            }

            else if (curr < Collections.max(queue)) { //현재 환자보다 더 위험도가 큰 환자가 있을 때
                m_tracer--;
                queue.offer(curr);
            }
            else {
                m_tracer--;
                count++;
            }




        }
    }


    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i<num; i++) {
            queue.offer(sc.nextInt());
        }

        System.out.println(getOrder(num, m, queue));

    }
}
