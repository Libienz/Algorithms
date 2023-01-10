package algorithm_ex.sorting_searching;

import java.util.*;

public class StallDecision {


    public static boolean isPossible(int stall1, int stall2,int[] valid_stall, int num_of_horse) {
        int shortest = Math.abs(valid_stall[stall2] - valid_stall[stall1]);
        //System.out.println("shortest : " + shortest );
        int count = num_of_horse;

        for (int n : valid_stall) {
            if (n != valid_stall[stall1] &&
                    n != valid_stall[stall2] &&
                    Math.abs(n-valid_stall[stall1]) > shortest &&
                    Math.abs(n-valid_stall[stall2]) >shortest) {
                count--;
                //System.out.println(num_of_horse);
                if (count == 0) return true;

            }

        }
        //System.out.println("impossible");
        return false;

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_of_stall = sc.nextInt();
        int num_of_horse = sc.nextInt();

        int[] valid_stall = new int[num_of_stall];

        for (int i = 0; i<num_of_stall; i++) {
            valid_stall[i] = sc.nextInt();
        }
        Arrays.sort(valid_stall);


        if (num_of_horse == 2) {
            System.out.println(valid_stall[valid_stall.length-1]-valid_stall[0]);
            return;
        }
        int max = 0;
        for (int i = 0; i<num_of_stall-1; i++) {
            for (int j = i+1; j<num_of_stall; j++) {
                if(isPossible(j,i,valid_stall,num_of_horse-2)) {
                    if(max < valid_stall[j]-valid_stall[i]) {
                        max = valid_stall[j]-valid_stall[i];
                    }
                }
            }
        }
        System.out.println(max);


    }
}
