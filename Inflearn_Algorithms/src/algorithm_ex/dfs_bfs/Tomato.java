package algorithm_ex.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
    static int n, m;
    public static int bfs(int[][] arr) {
        int level = 0;
        Queue<Point> q = new LinkedList<>();
        //익은 토마토의 위치를 큐에 넣는다.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();
//            System.out.println("q = " + q);
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();

                //현재 위치의 상
                if (cur.uPoint().isInBoundary() && arr[cur.uPoint().r][cur.uPoint().c] == 0) {
                    Point point = cur.uPoint();
                    q.add(point);
                    arr[point.r][point.c] = 1;
                }
                if (cur.dPoint().isInBoundary() && arr[cur.dPoint().r][cur.dPoint().c] == 0) {
                    Point point = cur.dPoint();
                    q.add(point);
                    arr[point.r][point.c] = 1;
                }
                if (cur.lPoint().isInBoundary() && arr[cur.lPoint().r][cur.lPoint().c] == 0) {
                    Point point = cur.lPoint();
                    q.add(point);
                    arr[point.r][point.c] = 1;
                }
                if (cur.rPoint().isInBoundary() && arr[cur.rPoint().r][cur.rPoint().c] == 0) {
                    Point point = cur.rPoint();
                    q.add(point);
                    arr[point.r][point.c] = 1;
                }

            }
            level++;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
            }
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] arr = new int[n][m];

        //배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(bfs(arr));

    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
    public boolean isInBoundary() {
        if (r >= 0 && c >= 0 && r < Tomato.n && c < Tomato.m) {
            return true;
        }
        return false;
    }
    public Point uPoint() {
        return new Point(r - 1, c);
    }
    public Point dPoint() {
        return new Point(r + 1, c);
    }
    public Point lPoint() {
        return new Point(r, c - 1);
    }
    public Point rPoint() {
        return new Point(r, c + 1);
    }

    @Override
    public String toString() {
        return "Point{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}