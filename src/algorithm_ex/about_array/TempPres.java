package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class TempPres {

    public static boolean everSame(int[] arr1, int[]arr2) {
        for (int i = 0; i< arr1.length; i++) {
            if (arr1[i] == arr2[i]) return true;
        }
        return false;
    }

    public static int getMax(ArrayList<Integer> arr) {
        int max = -1;
        for (int num : arr) {
            if (max < num) max = num;
        }
        return max;
    }

    public static int solution(int[][] arr, int num) {

        int count = 0;
        ArrayList<Integer> same_arr = new ArrayList<>();
        for (int i = 0; i< num; i++) {
            for(int j = 0; j<num; j++) {
                if(i==j) continue;
                if(everSame(arr[i], arr[j])) {
                    count++;
                }
            }
            same_arr.add(count);
            count = 0;
        }
        return same_arr.indexOf(getMax(same_arr)) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_of_student = sc.nextInt();
        int[][] arr = new int[num_of_student][5];
        ArrayList<Integer> same_class = new ArrayList<>();
        for (int i = 0; i< num_of_student; i++) {
            for (int j = 0; j<5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(arr,num_of_student));

    }
}
