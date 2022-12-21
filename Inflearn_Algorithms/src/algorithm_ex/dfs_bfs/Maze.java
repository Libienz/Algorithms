package algorithm_ex.dfs_bfs;

import java.util.Scanner;

public class Maze {

    static int[][] maze = new int[7][7];
    static boolean[][] visited = new boolean[7][7];
    static int count = 0;
    public static boolean isableToGo(int i, int j) {

        if (i > 6 || j > 6 || i < 0 || j < 0 || visited[i][j] || maze[i][j] == 1) { // 인덱스 벗어나거나 이미 방문한 적 있거나 벽일 떄는 못감
            return false;
        }
        else  {
            return true;
        }

    }
    public static void dfs(int i,int j) {
        if (i == 6 && j == 6) {
            count++;
        }

        else {
            if(isableToGo(i-1,j)) { //상
                visited[i-1][j] = true;
                dfs(i-1, j);
                visited[i-1][j] = false;
            }
            if(isableToGo(i+1,j)) { //하
                visited[i+1][j] = true;
                dfs(i+1, j);
                visited[i+1][j] = false;
            }
            if(isableToGo(i,j-1)) { //좌
                visited[i][j-1] = true;
                dfs(i, j-1);
                visited[i][j-1] = false;
            }
            if(isableToGo(i,j+1)) { //우
                visited[i][j+1] = true;
                dfs(i, j+ 1);
                visited[i][j+1] = false;
            }

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        visited[0][0] = true; // 출발지 0,0
        dfs(0, 0);
        System.out.println(count);


    }
}
