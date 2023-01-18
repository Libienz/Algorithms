package algorithm_ex.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class MazeShortestPath {

    public final static int RSIZE = 7;
    public final static int CSIZE = 7;
    public static int[][] maze = new int[RSIZE][CSIZE];
    public static int sp = Integer.MAX_VALUE;

    public static void dfs(int r, int c, int len) {

        //도착
        if (r == RSIZE - 1 && c == CSIZE - 1) {
//            System.out.println("MazeShortestPath.dfs");
            //도착까지 경로의 길이가 현재 최소경로 보다 짧다면 갱신
            if (len < sp) {
                sp = len;
            }
            return;
        }
        //상
        if (isInBoundary(r - 1, c) && maze[r - 1][c] == 0) {
//            System.out.println("상");
            maze[r - 1][c] = 1;
            dfs(r - 1, c, len+1);
            maze[r - 1][c] = 0;
        }
        //하
        if (isInBoundary(r + 1, c) && maze[r + 1][c] == 0) {
//            System.out.println("하");
            maze[r + 1][c] = 1;
            dfs(r + 1, c, len + 1);
            maze[r + 1][c] = 0;
        }
        //좌
        if (isInBoundary(r, c - 1) && maze[r][c - 1] == 0) {
//            System.out.println("좌");
            maze[r][c - 1] = 1;
            dfs(r, c - 1, len + 1);
            maze[r][c - 1] = 0;
        }
        //우
        if (isInBoundary(r, c + 1) && maze[r][c + 1] == 0) {
//            System.out.println("우");
            maze[r][c + 1] = 1;
            dfs(r, c + 1, len + 1);
            maze[r][c + 1] = 0;
        }




    }

    public static boolean isInBoundary(int r, int c) {
        if (r >= 0 && r < RSIZE && c >= 0 && c < CSIZE) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //미로 초기화
        for (int i = 0; i < RSIZE; i++) {
            for (int j = 0; j < CSIZE; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        maze[0][0] = 1;
        dfs(0, 0, 0);

        if (sp == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(sp);

    }

}
