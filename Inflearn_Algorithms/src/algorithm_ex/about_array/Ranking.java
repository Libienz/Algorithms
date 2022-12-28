package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ranking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            arr.add(sc.nextInt());
        }

        for (int i = 0; i < cnt; i++) {
            int score = arr.get(i);
            int rank = 1;
            for (int j = 0; j < cnt; j++) {
                if (i == j) {
                    continue;
                }
                if (score < arr.get(j)) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }

}