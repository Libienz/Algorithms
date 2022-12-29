package algorithm_ex.about_array;

import java.util.Scanner;

public class Mentor {

    //i가 j를 가르칠 수 있는가?
    public static boolean canTeach(int mentor, int menti, int testCnt, int[][] arr) {
        //i번째 테스트에서 mentor의 등수가 menti보다 높다면 가르칠 수 없음
        int mentorRank = 0;
        int mentiRank = 0;

        for (int i = 0; i < testCnt; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == mentor+1) {
                    mentorRank = j;
                }
                if (arr[i][j] == menti+1) {
                    mentiRank = j;
                }
            }
            if (mentorRank > mentiRank) {
                return false;
            }
            mentorRank = 0;
            mentiRank = 0;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int testCnt = sc.nextInt();
        int res = 0;


        //i학생은 j를 멘토링 할 수 있는지 확인할 수 있는 배열 생성 및 초기화 enbMent
        boolean[][] enbMent = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                enbMent[i][j] = true;
            }
        }

        //테스트 결과 입력으로부터 가져와서 세팅 하기 arr
        int[][] arr = new int[testCnt][size];
        for (int i = 0; i < testCnt; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                if (canTeach(i, j, testCnt, arr)) {
                    res++;

                }
            }
        }

        System.out.println(res);

    }
}
