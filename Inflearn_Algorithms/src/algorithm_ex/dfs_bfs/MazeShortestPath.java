package algorithm_ex.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Coordinate {

    int r, c;
    public static final int ROW_SIZE = 7;
    public static final int COL_SIZE = 7;

    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public boolean isValid() {
        if (this.c >= 0 && this.c < COL_SIZE && this.r >= 0 && this.r < ROW_SIZE) {
            return true;
        } else {
            return false;
        }
    }

    public Coordinate getRight() {
        return new Coordinate(this.r, this.c + 1);
    }

    public Coordinate getLeft() {
        return new Coordinate(this.r, this.c - 1);
    }

    public Coordinate getUp() {
        return new Coordinate(this.r - 1, this.c);
    }

    public Coordinate getDown() {
        return new Coordinate(this.r + 1, this.c);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}
public class MazeShortestPath {

    public static final int ROW_SIZE = 7;
    public static final int COL_SIZE = 7;
    public static int[][] maze;


    public static int bfs(Coordinate c) {
//
        boolean[][] visited = new boolean[ROW_SIZE][COL_SIZE];
        visited[0][0] = true;
        Queue<Coordinate> q = new LinkedList<>();
        q.add(c);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
//            System.out.println("level = " + level);
//            System.out.println("q = " + q);
            for (int i = 0; i < len; i++) {

                Coordinate cur = q.poll();
//                visited[cur.r][cur.c] = true;

                if (cur.r == 6 && cur.c == 6) {
                    return level;
                }
                //상
                Coordinate up = cur.getUp();
                if (up.isValid() && !visited[up.r][up.c] && maze[up.r][up.c] != 1 ) {
                    q.add(up);
                    visited[up.r][up.c] = true;
                }
                //우
                Coordinate right = cur.getRight();
                if (right.isValid() && !visited[right.r][right.c] && maze[right.r][right.c] != 1) {
                    q.add(right);
                    visited[right.r][right.c] = true;
                }
                //좌
                Coordinate left = cur.getLeft();
                if (left.isValid() && !visited[left.r][left.c] && maze[left.r][left.c] != 1) {
                    q.add(left);
                    visited[left.r][left.c] = true;
                }
                //하
                Coordinate down = cur.getDown();
                if (down.isValid() && !visited[down.r][down.c] && maze[down.r][down.c] != 1) {
                    q.add(down);
                    visited[down.r][down.c] = true;
                }

            }
            level++;
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maze = new int[ROW_SIZE][COL_SIZE];

        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COL_SIZE; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        int hop = bfs(new Coordinate(0, 0));
        System.out.println(hop);


    }
}
