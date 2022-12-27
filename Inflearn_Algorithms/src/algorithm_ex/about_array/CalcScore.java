package algorithm_ex.about_array;

import java.util.Scanner;

public class CalcScore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int point = 0; //해당 문제에 부여되는 점수 (가산점 포함)
        int score = 0; //총 점수

        for (int i = 0; i < cnt; i++) {
            if (sc.nextInt() == 1) {
                score += (++point);
            } else {
                point = 0;
            }
        }
        System.out.println(score);


    }
}
