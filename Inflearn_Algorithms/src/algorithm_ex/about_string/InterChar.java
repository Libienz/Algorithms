package algorithm_ex.about_string;

import java.util.ArrayList;
import java.util.Scanner;

public class InterChar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = sc.next().charAt(0);
        char[] chars = s.toCharArray();

        int[] distance = new int[s.length()];
        ArrayList<Integer> targetIdxs = new ArrayList<>();

        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                targetIdxs.add(i);
            }
        }

        for (int i = 0; i < distance.length; i++) {
            for (Integer ti : targetIdxs) {
                if (distance[i] > Math.abs(ti - i)) {
                    distance[i] = Math.abs(ti - i);
                }
            }
        }
        for (int d : distance) {
            System.out.printf("%d ", d);
        }

    }
}
