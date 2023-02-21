package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Mentor {

    private static boolean canTeach(int s1, int s2, ArrayList<ArrayList<Integer>> score) {
        ArrayList<Integer> s1Scores = score.get(s1);
        ArrayList<Integer> s2Scores = score.get(s2);

//        System.out.println("s2Scores = " + s2Scores);
//        System.out.println("s1Scores = " + s1Scores);
        for (int i = 0; i < s1Scores.size(); i++) {
            int s1Score = s1Scores.get(i);
            int s2Score = s2Scores.get(i);
            if (s1Score > s2Score) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //학생 수
        int m = sc.nextInt(); //m번의 수학테스트가 진행되었음

        ArrayList<ArrayList<Integer>> score = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            score.add(new ArrayList<Integer>());
        }
        score.add(new ArrayList<>());


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = sc.nextInt(); //r번 학생은 i+1번째 테스트에서 j+1등
                score.get(r).add(j + 1);
            }
        }

//        System.out.println(score);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (canTeach(i+1, j+1, score)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
