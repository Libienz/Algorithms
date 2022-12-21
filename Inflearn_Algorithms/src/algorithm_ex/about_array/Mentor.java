package algorithm_ex.about_array;

import java.util.Scanner;

public class Mentor {

    public static int indexOf(int[] arr, int num) {
        for (int i = 0; i< arr.length; i++) {
            if (arr[i]==num) return i;
        }
        return -1;
    }
    public static boolean ableToTeach(int mentor, int menti, int[][] test_res) {
        for (int i = 0; i<test_res.length; i++) {
            if (indexOf(test_res[i],mentor) > indexOf(test_res[i],menti)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num_of_student = sc.nextInt();
        int num_of_test = sc.nextInt();
        int[][] test_res = new int[num_of_test][num_of_student];
        boolean[][] can_teach = new boolean[num_of_student][num_of_student];
        for (int i = 0; i<num_of_test; i ++) {
            for (int j = 0; j<num_of_student; j++) {
                test_res[i][j] = sc.nextInt();
            }
        }

        //어떤 두수를 찾고 싶은데 그 두수는 3개의 테스트 결과에서 모두 순서가 같아야함
        //12가지 경우의 수 중에서 가능한 것을 찾는다.

        int count = 0;
        for (int i = 1; i<=num_of_student; i ++) { //i -> mento
            for (int j = 1; j<=num_of_student; j++) { //j -> menti
                if( i==j) continue;
                if(ableToTeach(i,j,test_res)) count++;
            }
        }

        System.out.println(count);

    }
}
