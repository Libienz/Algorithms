package algorithm_ex.stack_queue;

import java.util.*;

public class PuppetDraw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int mvcount = sc.nextInt();
//        System.out.println("mvcount = " + mvcount);
        int[] mvs = new int[mvcount];
        for (int i = 0; i < mvcount; i++) {
            mvs[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i : mvs) {
            //i번째 레인을 바구니에 옮길 것임
//            System.out.println("i = " + i);
//            System.out.println("i = " + i);
            //i 제대로 나옴
            //애초에 루프가 지금 ...
            int obj = 0;
            for (int j = 0; j < n; j++) {
                obj = 0;
                if (board[j][i - 1] == 0) {
                    continue;
                } else {
                    obj = board[j][i - 1];
//                    System.out.println("obj = " + obj);
                    board[j][i - 1] = 0;

                }
            }

            if (stack.isEmpty() && obj != 0) {
                stack.push(obj);
            } else if (!stack.isEmpty() && obj != 0){
                if (obj == stack.peek()) {
                    stack.pop();
                    res += 2;
                } else {
                    stack.push(obj);
                }
            }
        }
        System.out.println(res);

    }
//        System.out.println(res);
}
