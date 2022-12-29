package algorithm_ex.about_array;


import java.util.ArrayList;
import java.util.Scanner;

public class TempPres {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] arr = new int[size][5];
        int cmax = 0;
        int pres = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //i학생과 j학생은 한번이라도 같은 반이었던 적이 있는가?
        for (int i = 0; i < size; i++) {
            int cnt = 0;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > cmax) {
                cmax = cnt;
                pres = i+1;
            }

        }
        System.out.println(pres);

    }
}
