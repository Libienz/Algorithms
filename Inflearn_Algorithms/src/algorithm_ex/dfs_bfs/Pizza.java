package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
    int r, c;
    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Location{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}
public class Pizza {

    static int n, m;
    static ArrayList<Location> ps;
    static ArrayList<Location> res; //선택한 피자집의 위치정보를 담는 배열
    static int count = 0;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;


    //고른 피자집이 res일때 최소배달거리를 구하는 메서드
    public static int getDistance(ArrayList<Location> pl) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //집이라면
                if (map[i][j] == 1) {
                    int minDist = Integer.MAX_VALUE;
                    for (Location l : pl) {
                        int dist = Math.abs(l.r - i) + Math.abs(l.c - j);
                        if (dist < minDist) {
                            minDist = dist;
                        }
                    }
                    res += minDist;
                }
            }
        }
        return res;
    }
    public static void dfs(int ch, int idx) {
        if (ch == m) {
            //m개의 피자집을 골랐다
//            count++;
//            System.out.println(res);
//            System.out.println("count = " + count);
            //고른 피자집 기준 피자배달거리의 합을 구한다
            int cur = getDistance(res);
            //구한 최소 피자 배달거리가 최소의 최소피자배달거리라면 갱신
            if (answer > getDistance(res)) {
                answer = cur;
            }

        } else {
            for (int i = idx; i < ps.size(); i++) {
                Location cur = ps.get(i);
                if (!res.contains(cur)) {
                    res.add(cur);
                    dfs(ch + 1, i + 1);
                    res.remove(res.size() - 1);
                } else {
                    continue;
                }

            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        ps = new ArrayList<>();
        res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                map[i][j] = num;
                if (num == 2) {
                    ps.add(new Location(i, j));
                }
            }
        }
//        System.out.println("ps = " + ps);

        dfs(0, 0);
        System.out.println(answer);

    }
}
