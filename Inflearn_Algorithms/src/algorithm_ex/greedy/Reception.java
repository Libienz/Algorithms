package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Reception {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //하객 수

        int[] timeLine = new int[72];
        for (int i = 0; i < 72; i++) {
            timeLine[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int at = sc.nextInt(); //하객 arrive time
            int lt = sc.nextInt(); //하객 leave time

            for (int j = at; j < lt; j++) {
                timeLine[j] = timeLine[j] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < timeLine.length; i++) {
            if (timeLine[i] > max) {
                max = timeLine[i];
            }
        }
        System.out.println(max);

    }
}
