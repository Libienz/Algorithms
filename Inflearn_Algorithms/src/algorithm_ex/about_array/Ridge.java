package algorithm_ex.about_array;

import java.util.Scanner;

public class Ridge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt()+2;
        int[][] map = new int[size][size];
        int cnt = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 0 || i == size - 1 || j == size - 1) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i < size-1; i++) {
            for (int j = 1; j < size-1; j++) {
                if (map[i][j] > map[i - 1][j] && map[i][j] > map[i][j - 1] && map[i][j] > map[i + 1][j] && map[i][j] > map[i][j + 1]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);



    }
}
