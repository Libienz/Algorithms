package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class CalcScore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//문제의 개수
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int w = 0;
        int score = 0;
        for (Integer num : arr) {
            if (num == 1) {
                score += 1 + w;
                w++;
            } else {
                w = 0;
            }
        }
        System.out.println(score);
    }
}
