package algorithm_ex.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island {

    static int size;
    static int[][] arr;
    static int res = 0;
    static boolean[][] check;

    public static void dfs(int r, int c) {
        //상
        check[r][c] = true;
        if (isInBoundary(r-1,c) && arr[r - 1][c] == 1 && check[r - 1][c] == false) {
            check[r - 1][c] = true;
            dfs(r - 1, c);
        }
        //하
        if (isInBoundary(r+1,c) && arr[r + 1][c] == 1 && check[r + 1][c] == false) {
            check[r + 1][c] = true;
            dfs(r + 1, c);
        }
        //좌
        if (isInBoundary(r,c-1) && arr[r][c-1] == 1 && check[r][c-1] == false) {
            check[r][c-1] = true;
            dfs(r, c-1);
        }
        //우
        if (isInBoundary(r,c+1) && arr[r][c+1] == 1 && check[r][c+1] == false) {
            check[r][c+1] = true;
            dfs(r, c + 1);
        }
        //상좌
        if (isInBoundary(r-1,c-1) && arr[r-1][c-1] == 1 && check[r-1][c-1] == false) {
            check[r-1][c-1] = true;
            dfs(r-1, c - 1);
        }
        //상우
        if (isInBoundary(r-1,c+1) && arr[r-1][c+1] == 1 && check[r-1][c+1] == false) {
            check[r-1][c+1] = true;
            dfs(r-1, c + 1);
        }
        //하좌
        if (isInBoundary(r+1,c-1) && arr[r+1][c-1] == 1 && check[r+1][c-1] == false) {
            check[r+1][c-1] = true;
            dfs(r+1, c - 1);
        }
        //하우
        if (isInBoundary(r+1,c+1) && arr[r+1][c+1] == 1 && check[r+1][c+1] == false) {
            check[r+1][c+1] = true;
            dfs(r+1, c + 1);
        }
    }

    public static boolean isInBoundary(int r, int c) {
        if (r >= 0 && c >= 0 && r < size && c < size) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new int[size][size];
        check = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = sc.nextInt();
                check[i][j] = false;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == 1 && check[i][j] == false) {
                    res++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(res);





    }
}
