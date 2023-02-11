package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ranking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n명의 학생이 있다.
        ArrayList<Integer> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            scores.add(sc.nextInt());
        }

        for (int i = 0; i < scores.size(); i++) {
            Integer score = scores.get(i);
            //i 번째 학생의 점수는 score
            int rank = 1;
            for (int j = 0; j < scores.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (scores.get(j) > score) {
                    rank++;
                }
            }
            System.out.print(rank +" ");
        }
    }

}