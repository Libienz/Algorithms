package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class GridMaxSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //n by n 배열 생성
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        //각 라인의 합을 구하고 최댓값을 구한다.
        int max = Integer.MIN_VALUE;

        //행 숫자들의 합 중 최대 살펴보기
        for (int i = 0; i < n; i++) {
            int sm = 0; // subMax
            for (int j = 0; j < n; j++) {
                sm += grid[i][j];
            }
            if (sm > max) {
                max = sm;
            }
        }
        //열 숫자들의 합 중 최대 살펴보기
        for (int j = 0; j < n; j++) {
            int sm = 0;
            for (int i = 0; i < n; i++) {
                sm += grid[i][j];
            }
            if (sm > max) {
                max = sm;
            }
        }

        //대각 숫자들의 합 중 최대 살펴보기
        int sm = 0;
        for (int i = 0; i < n; i++) {

            sm += grid[i][i];
        }
        if (sm > max) {
            max = sm;
        }

        System.out.println(max);

    }
}
