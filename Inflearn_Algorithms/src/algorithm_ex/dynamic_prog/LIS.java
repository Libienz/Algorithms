package algorithm_ex.dynamic_prog;

import java.util.ArrayList;
import java.util.Scanner;

public class LIS {

    public static ArrayList<Integer> seq = new ArrayList<>();
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        //수열 작성
        for (int i = 0; i < length; i++) {
            seq.add(sc.nextInt());
        }

        dfs(0, Integer.MIN_VALUE, 0);
        System.out.println(answer);

    }

    //완전 탐색 dfs 구조 부분집합과 유사 ..
    public static void dfs(int index, int prev, int length) {

        if (index == seq.size()) {
            if (length > answer) {
                answer = length;
            }
        }
        else {

            if (seq.get(index) < prev) {
                dfs(index + 1, prev, length);
            }
            else {
                dfs(index + 1, seq.get(index), length + 1);
                dfs(index + 1, prev, length);
            }

        }
    }
    private static int getLis(ArrayList<Integer> seq) {

        return 0;
    }
}
