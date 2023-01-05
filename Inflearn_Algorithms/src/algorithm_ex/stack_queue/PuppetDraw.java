package algorithm_ex.stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PuppetDraw {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] board = new int[size][size];
        int cnt = 0;

        //보드 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        //moves 배열 초기화
        int mvSize = sc.nextInt();
        int[] moves = new int[mvSize];
        for (int i = 0; i < mvSize; i++) {
            moves[i] = sc.nextInt() - 1;
        }

        //바구니
        Stack<Integer> bucket = new Stack<>();

        //move 배열의 내용에 따라 하나씩 바구니에 옮긴다.
        for (int move : moves) {

            //크레인이 0이 아닌 인형을 발견할 때까지 내려간다.
            for (int i = 0; i < size; i++) {
                if (board[i][move] == 0) {
                    continue;
                }
                //여기로 왔다는 것은 0이 아닌 것을 발견하였다는 것 버켓에 넣을 것임
                //버켓에 들어가게 될 인형의 종류: type
                int type = board[i][move];
                board[i][move] = 0;

                //버켓이 비어있거나 버켓에 맨 위에 담겨있는 인형의 종류가 내가 넣으려는 인형의 종류와 다르다면
                //그냥 넣으면 된다.
                if (bucket.empty() || bucket.peek() != type) {
                    bucket.push(type);
                    //break해야 된다.. 반복문 돌지 않도록! 이런 부분 빠릿하게 생각해낼 수 있어야..
                    break;
                } else if (bucket.peek() == type) {
                    //넣으려는 인형이 꼭대기에 있는 인형과 일치한다면
                    //pop하고 두개가 없어졌음을 명시
                    bucket.pop();
                    cnt = cnt + 2;
                    break;
                }

            }
        }
        System.out.println(cnt);





    }
}
