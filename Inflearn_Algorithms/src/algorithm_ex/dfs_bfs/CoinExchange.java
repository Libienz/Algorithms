package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoinExchange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //동전 종류 개수
        ArrayList<Integer> types = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            types.add(sc.nextInt());
        }
        int m = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.add(m); //거슬러줘야 하는 금액이 q에 들어가게 된다.
        int level = 0;
        while (!q.isEmpty()) {
//            System.out.println("level = " + level);
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer ch = q.poll();
                if (ch == 0) {
                    System.out.println(level);
                    return;
                } else {
                    for (Integer type : types) {
                        q.add(ch - type);
                    }
                }
            }
            level++;
        }
    }
}
