package algorithm_ex.about_array;

import java.util.Scanner;

public class Ridge {

    public static int countRidge(int[][] arr, int length) {
        int count = 0;
        for (int i = 1; i<=length; i++) {
            for (int j = 1; j <= length; j++) {
                if (arr[i][j]> arr[i-1][j] &&  arr[i][j]> arr[i][j-1]
                    && arr[i][j] > arr[i+1][j] && arr[i][j] >arr[i][j+1]) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] grid = new int[length+2][length+2];
        for (int i = 1; i<=length; i++) {
            for (int j = 1; j <= length; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(countRidge(grid, length));
/*

        for (int i = 0; i<length+2; i++) {
            for (int j = 0; j < length+2; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }

*/


    }
}
