package algorithm_ex.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Tomato {


    static int[][] storage;
    static int row, col;

    public static boolean isGoingToRipe(int i, int j) {
        if (i >= row || i < 0 || j >= col || j < 0) {
            return false;
        }
        if (storage[i][j] == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isAllTomatoDone(int[][] storage) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (storage[i][j] == 0) {
                    return false;
                }

            }
        }
        return true;
    }
    public static int getLeastDayForAllTomatoDone(int[][] storage) {

        int day = 0;
        Queue<Coord> Q = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (storage[i][j] == 1) {
                    if (isGoingToRipe(i + 1, j)) {
                        Q.add(new Coord(i + 1, j));
                    }
                    if (isGoingToRipe(i - 1, j)) {
                        Q.add(new Coord(i - 1, j));
                    }
                    if (isGoingToRipe(i, j + 1)) {
                        Q.add(new Coord(i, j + 1));
                    }
                    if (isGoingToRipe(i, j - 1)) {
                        Q.add(new Coord(i, j - 1));
                    }
                }
            }
        }
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Coord cur = Q.poll();
                if (isGoingToRipe(cur.row+1, cur.col)) {
                    Q.add(new Coord(cur.row + 1, cur.col));
                    storage[cur.row + 1][cur.col] = 1;
                }
                if (isGoingToRipe(cur.row-1, cur.col)) {
                    Q.add(new Coord(cur.row - 1, cur.col));
                    storage[cur.row - 1][cur.col] = 1;
                }
                if (isGoingToRipe(cur.row, cur.col+1)) {
                    Q.add(new Coord(cur.row, cur.col + 1));
                    storage[cur.row][cur.col + 1] = 1;
                }
                if (isGoingToRipe(cur.row, cur.col-1)) {
                    Q.add(new Coord(cur.row, cur.col - 1));
                    storage[cur.row][cur.col - 1] = 1;
                }

            }
            day++;
        }

        if (isAllTomatoDone(storage)) {
            return day;
        }
        else {
            return -1;
        }



    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        col = sc.nextInt();
        row = sc.nextInt();

        storage = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                storage[i][j] = sc.nextInt();
            }
        }
        System.out.println(getLeastDayForAllTomatoDone(storage));
    }


}
