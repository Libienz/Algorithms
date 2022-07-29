package algorithm_ex.sorting_searching;

import java.util.*;

public class StallDecision {

    public static int getMaxDistance(int num_of_stall, int num_of_horse, int[] valid_stall, Set<Integer> possible_answer) {

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_of_stall = sc.nextInt();
        int num_of_horse = sc.nextInt();

        int[] valid_stall = new int[num_of_stall];

        for (int i = 0; i<num_of_stall; i++) {
            valid_stall[i] = sc.nextInt();
        }
        Arrays.sort(valid_stall);

        Set<Integer> possible_answer = new HashSet<>();

        for (int i = 1; i<num_of_stall; i++) {
            for (int j = i-1; j>=0; j--) {
                possible_answer.add(valid_stall[i] - valid_stall[j]);
            }
        }


    }
}
