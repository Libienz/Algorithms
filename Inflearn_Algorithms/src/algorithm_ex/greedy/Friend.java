package algorithm_ex.greedy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Friend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); //학생 명수
        int r = sc.nextInt(); //관계 개수

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(null);

        for (int i = 0; i < s; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            arr.get(f1).add(f2);
        }

        int s1 = sc.nextInt();
        int s2 = sc.nextInt();

        //s1과 s2는 친구인가를 알아내야 함

    }
}
