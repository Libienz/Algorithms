package algorithm_ex.about_array;


import java.util.ArrayList;
import java.util.Scanner;

public class TempPres {

    private static boolean everSame(int s1, int s2, int[][] ca) {

        for (int i = 0; i < 5; i++) {
            int c1 = ca[s1][i]; //s1학생이 i학년에 c1반이었음
            int c2 = ca[s2][i]; //s2학생이 i학년에 c2반이었음

            if (c1 == c2) {
                return true;
            }

        }
        return false;



    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); //학생 수
        //class arr 학생들이 특정학년에 몇반이었는지 알 수 있는 배열
        //학생들은 row로 학년은 col로 구분
        int[][] ca = new int[s][5];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < 5; j++) {
                ca[i][j] = sc.nextInt();
            }
        }

        //relation -> i와 j학생이 같은 반이었던적이 있는지 알려주는 배열
        boolean[][] rl = new boolean[s][s];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                if (i == j) {
                    continue;
                }
                //i학생과 j학생은 같은 반이었던 적이 있는가?
                if (everSame(i, j, ca)) {
                    rl[i][j] = true;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int tp = 0;
        for (int i = 0; i < rl.length; i++) {
            //i학생과 한번이라도 같은 반이었던 학생수
            int cnt = 0;
            for (int j = 0; j < rl[0].length; j++) {
                if (i == j) {
                    continue;
                }
                if (rl[i][j]) {
                    cnt++;
                }
            }
            if (cnt > max) {
                max = cnt;
                tp = i + 1;
            }
        }

        System.out.println(tp);
//        for (int i = 0; i < rl.length; i++) {
//            for (int j = 0; j < rl.length; j++) {
//                System.out.print(rl[i][j]+ " ");
//            }
//            System.out.println();
//        }
    }
}
