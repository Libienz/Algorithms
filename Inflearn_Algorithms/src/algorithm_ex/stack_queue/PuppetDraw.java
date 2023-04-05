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
            for (int j = 0; j<n; j++) {
                if (board[j][i - 1] == 0) {
                    continue;
                } else {
                    int obj = board[j][i-1];
                    board[j][i-1] = 0;
                    if (stack.isEmpty()) {
                        stack.push(obj);
                    }

                    else {
                        if (obj == stack.peek()) {
                            stack.pop();
                            res += 2;
                        }
                        else {
                            stack.push(obj);
                        }

                    }

                }
            }

        }
        System.out.println(res);
    }
}
