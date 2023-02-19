package algorithm_ex.about_array;

import java.util.Scanner;

public class Ridge {

    static int[][] map;

    private static boolean isRidge(int r, int c) {
        int h = map[r][c];
        int u = map[r - 1][c];
        int d = map[r + 1][c];
        int l = map[r][c - 1];
        int rg = map[r][c + 1];
        if (h > u && h > d && h > l && h > rg) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //n+2 by n+2 격자 생성
        map = new int[n + 2][n + 2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (isRidge(i, j)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
