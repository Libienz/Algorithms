package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;
/*
방향을 바꾸어 생각해보자
답이 될 수 있는 모든 경우에 대해서 top까지 갔을 때 우리가 입력한 값이 나오는지 확인
 */
public class PascalInfer {

    static int N;
    static int top;
    static ArrayList<Integer> maybe_answer = new ArrayList<>();
    static boolean[] permutation_check;
    static boolean succesed = false;

    public static boolean isValidAnswer(ArrayList<Integer> maybe_answer) {
        ArrayList<Integer> temp;
        temp = (ArrayList<Integer>) maybe_answer.clone(); //깊은 복사
        //System.out.println("temp = " + temp);
        while (temp.size() > 1) {
            int len = temp.size();

            //System.out.println("len = " + len);
            for (int i = 0; i <= len-2; i ++) {
                //System.out.println("temp = " + temp);
                int num1 = temp.get(i);
                int num2 = temp.get(i+1);
                temp.add(num1 + num2);
            }
            for (int i = 0; i < len; i++) {
                temp.remove(0);
            }
        }
        if (temp.get(0) == top) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void dfs(int choiced,ArrayList<Integer> maybe_answer) {
        if (choiced == N) {
            //System.out.println("maybe_answer = " + maybe_answer);
            if (isValidAnswer(maybe_answer)) {
                succesed = true;
                //System.out.println("PascalInfer.dfs");
                for (int num : maybe_answer) {
                    System.out.print(num + " ");
                }
            }


        }
        else {
            if (succesed) {
                return;
            }
            for (int i = 1; i <= N; i++) {
                if (permutation_check[i]) {
                    continue;
                }
                else {
                    permutation_check[i] = true;
                    maybe_answer.add(i);
                    dfs(choiced + 1, maybe_answer);
                    maybe_answer.remove((Integer) i);
                    permutation_check[i] = false;
                }

            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        top = sc.nextInt();
        permutation_check = new boolean[N + 1];
        dfs(0, maybe_answer);
    }
}
