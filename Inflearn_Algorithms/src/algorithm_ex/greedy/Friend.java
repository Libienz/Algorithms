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

        ArrayList<Set<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
//            boolean needNewGroup = true;
            int f1gNum = -1;
            int f2gNum = -1;


            for (int j = 0; j < arr.size(); j++) {

                if (arr.get(j).contains(f1)) {
//                    f1isInGroup = true;
                    f1gNum = j;
                }
                if (arr.get(j).contains(f2)) {
//                    f2isInGroup = true;
                    f2gNum = j;
                }

            }
            //둘다 그룹에 속해있지 않은 경우
            if (f1gNum == -1 && f2gNum == -1) {
                HashSet<Integer> g = new HashSet<>();
                g.add(f1);
                g.add(f2);
                arr.add(g);
            }
            //둘다 그룹에 속해있는 경우
            else if (f1gNum != -1 && f2gNum != -1) {
                if (f1gNum != f2gNum) {
                    Set<Integer> set1 = arr.get(f1gNum);
                    Set<Integer> set2 = arr.get(f2gNum);
                    HashSet<Integer> newSet = new HashSet<>();

                    for (Integer n : set1) {
                        newSet.add(n);
                    }
                    for (Integer n : set2) {
                        newSet.add(n);
                    }
                    arr.remove(f1gNum);
                    arr.remove(f2gNum);
                    arr.add(newSet);
                }
            }
            //한명만 그룹에 속해있는 경우
            else {
                if (f1gNum == -1) {
                    arr.get(f2gNum).add(f1);
                } else {
                    arr.get(f1gNum).add(f2);
                }
            }


        }

        int s1 = sc.nextInt();
        int s2 = sc.nextInt();

        //s1과 s2는 친구인가를 알아내야 함

//        System.out.println("arr = " + arr);
        for (Set<Integer> g : arr) {
            if (g.contains(s1) && g.contains(s2)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }
}
