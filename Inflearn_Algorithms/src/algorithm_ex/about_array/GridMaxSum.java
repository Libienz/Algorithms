package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class GridMaxSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] grid = new int[length][length];
        for (int i = 0; i<length; i++) {
            for (int j = 0; j<length; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> grid_summation = new ArrayList<>();
        int row_sum = 0;
        int col_sum = 0;
        for (int i = 0; i<length; i++) {
            for (int j = 0; j<length; j++) {
                row_sum +=grid[i][j];
                col_sum +=grid[j][i];
            }
            grid_summation.add(row_sum);
            grid_summation.add(col_sum);
            row_sum = 0;
            col_sum = 0;
        }
        int diagnol_sum = 0;
        for(int i = 0; i<length; i++) {
            diagnol_sum += grid[i][i];
        }
        grid_summation.add(diagnol_sum);
        diagnol_sum = 0;
        for (int i = 0; i<length; i++) {

            diagnol_sum += grid[i][length-i-1];

        }
        grid_summation.add(diagnol_sum);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<grid_summation.size(); i++) {
            if (grid_summation.get(i)>max) {
                max = grid_summation.get(i);
            }
        }


        System.out.print(max);

    }

}
