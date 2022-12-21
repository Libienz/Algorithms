package algorithm_ex.dfs_bfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxScore {

    static int p_num, lim;
    static int max = 0;
    static Map<Integer, Integer> hashMap;
    static int[] score;
    static int[] time;
    static boolean[] solved;

    public static void dfs(int index, int s_sum, int time_used) {
        if (time_used > lim) { //shortcut
            return;
        }
        if (index == p_num) {
            if (s_sum > max) {
                max = s_sum;
            }

        }
        else {

            dfs(index+1,s_sum+score[index],time_used+time[index]);
            dfs(index + 1, s_sum, time_used);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        p_num = sc.nextInt();
        lim = sc.nextInt();
        solved = new boolean[p_num];
        score = new int[p_num];
        time = new int[p_num];
        //hashMap = new HashMap<>();

        for (int i = 0; i < p_num; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        dfs(0,0,0);
        System.out.println(max);

    }
}
