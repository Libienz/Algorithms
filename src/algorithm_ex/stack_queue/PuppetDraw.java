package algorithm_ex.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class PuppetDraw {

    public static int game(int num_of_stacks, int size_of_stacks, int[][] board, int []moves) {

        Stack<Integer> res_stack = new Stack<>();

        int count = 0;
        for (int i=0; i<moves.length; i++) {
            for (int j = 0; j<num_of_stacks; j++) {
                if (board[j][moves[i]-1] == 0) {
                    continue;
                }
                else{
                    if (res_stack.isEmpty()) {
                        res_stack.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                    if (res_stack.get(res_stack.size()-1) == board[j][moves[i]-1]) {
                        count = count +2;
                        res_stack.pop();
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                    res_stack.push(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }

            }
        }
        /*for (int i = 0; i<res_stack.size(); i++) {
            System.out.print(res_stack.get(i) + " ");
        }*/

        /*int prev =0;
        boolean is_counting =false;
        int curr = 0;
        int count = 0;
        while(!res_stack.isEmpty()) {
            curr = res_stack.pop();
            if (prev ==  curr) {
                if (is_counting)  {
                    prev = curr;
                    count = count+1;
                }
                else {
                    count = count+2;
                    prev = curr;
                    is_counting = true;
                }

            }
            else {
                prev = curr;
                is_counting = false;
            }
        }*/

    return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num_of_stacks = sc.nextInt();
        int size_of_stacks = num_of_stacks;
        int[][] board = new int[size_of_stacks][num_of_stacks];
        for (int i = 0; i<size_of_stacks; i++) {
            for (int j = 0; j<num_of_stacks; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int size_of_moves = sc.nextInt();
        int[] moves = new int[size_of_moves];
        for (int i = 0; i<size_of_moves; i++) {
            moves[i] = sc.nextInt();
        }

        int deleted_puppet_num = game(num_of_stacks,size_of_stacks,board,moves);
        System.out.println(deleted_puppet_num);
    }
}
