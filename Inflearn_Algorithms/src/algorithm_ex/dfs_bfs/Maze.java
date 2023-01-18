package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class Maze {

    static final int RSIZE = 7;
    static final int CSIZE = 7;
    static int[][] maze = new int[RSIZE][CSIZE];;
    static int res = 0;

    public static void dfs(int r, int c) {
        //목적지 도착
        if (r == RSIZE-1 && c == CSIZE-1) {
            res++;
            return;
        }

        //상
        if (isInBoundary(r - 1, c) && maze[r - 1][c] == 0) {
//            System.out.println("상");
            maze[r - 1][c] = 1;
            dfs(r - 1, c);
            maze[r - 1][c] = 0;
        }
        //하
        if (isInBoundary(r + 1, c) && maze[r + 1][c] == 0) {
//            System.out.println("하");
            maze[r+1][c] = 1;
            dfs(r + 1, c);
            maze[r + 1][c] = 0;
        }
        //좌
        if (isInBoundary(r, c - 1) && maze[r][c - 1] == 0) {
//            System.out.println("좌");
            maze[r][c - 1] = 1;
            dfs(r, c - 1);
            maze[r][c - 1] = 0;
        }
        //우
        if (isInBoundary(r, c + 1) && maze[r][c + 1] == 0) {
//            System.out.println("우");
            maze[r][c + 1] = 1;
            dfs(r, c + 1);
            maze[r][c + 1] = 0;
        }


    }

    public static boolean isInBoundary(int r, int c) {
        if (r >= 0 && r < RSIZE && c >= 0 && c < CSIZE) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //출발지

        for (int i = 0; i < RSIZE; i++) {
            for (int j = 0; j < CSIZE; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        maze[0][0] = 1;
        dfs(0, 0);
        System.out.println(res);

    }
}
