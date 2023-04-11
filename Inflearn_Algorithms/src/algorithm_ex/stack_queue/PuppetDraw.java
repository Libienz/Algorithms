package algorithm_ex.stack_queue;

import java.util.*;

public class PuppetDraw {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //인형 뽑기 상황 보드 초기화
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        //인형 옮기게 되는 횟수
        int mvcount = sc.nextInt();
        int[] mvs = new int[mvcount];
        //인형 옮기는 정보
        for (int i = 0; i < mvcount; i++) {
            mvs[i] = sc.nextInt();
        }

        //인형은 stack에 옮겨진다.
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        //옮기는 정보에 맞추어 stack에 인형을 옮긴다.
        for (int i : mvs) {
            //i번째 레인에 있는 인형을 stack으로 옮긴다.
            //i번째 레인에서 0이 아닌 다른 인형을 만날때 까지 행(j)을 내린다.
            int obj = 0;
            for (int j = 0; j < n; j++) {
                int cur = board[j][i-1];
                if (cur == 0) {
                    continue;
                } else {
                    obj = cur;
                    board[j][i - 1] = 0;
                    break;
                }
            }

            if (obj == 0) {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(obj);
            } else {
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
}
