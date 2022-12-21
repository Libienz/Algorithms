package algorithm_ex.greedy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Friend {

    public static boolean f_flag;
    public static ArrayList<Set<Integer>> group = new ArrayList<>();

    public static boolean allDisjoint(ArrayList<Set<Integer>> group) {

        for (int i = 0; i < group.size() - 1; i++) {
            for (int j = i + 1; j < group.size(); j++) {
                if (isDisjoint(group.get(i), group.get(j))) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isDisjoint(Set<Integer> s1, Set<Integer> s2) {

        for (int n : s1) {
            if (s2.contains(n)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int s_num = sc.nextInt();
        int pair_num = sc.nextInt();

        for (int i = 0; i < pair_num; i++) {

            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            //s1과 s2는 친구
            for (Set<Integer> s : group) {
                if (s.contains(s1)) {
                    s.add(s2);
                    f_flag = true;
                } else if (s.contains(s2)) {
                    s.add(s1);
                    f_flag = true;
                }
            }
            if (!f_flag) {
                Set<Integer> new_group = new HashSet<>();
                new_group.add(s1);
                new_group.add(s2);
                group.add(new_group);
            }
            f_flag = false;

        }
        //그룹 나누기 완료 교집합 확인할 차례
        while (!allDisjoint(group)) { // 모든 그룹에 교집합이 하나라도 존재한다면
            for (int i = 0; i < group.size()-1; i++) {
                for (int j = i + 1; j < group.size(); j++) {
                    if (!isDisjoint(group.get(i), group.get(j))) { //교집합이 있다면
                        for (int num : group.get(j)) {
                            group.get(i).add(num);
                        }
                        group.remove(j);
                    }
                }
            }
        }

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        //System.out.println(group);
        for (Set<Integer> s : group) {

            if (s.contains(p1)) {
                for (int num : s) {
                    //System.out.println(num);
                    if (num == p2) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");



    }
}
