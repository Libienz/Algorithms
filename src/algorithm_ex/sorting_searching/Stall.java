package algorithm_ex.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Stall {

    public static boolean isPossibleDistance(int dist, int[] stall_loc) {

        for (int i = 0; i<stall_loc.length-1; i++) {
            for (int j = i+1; j< stall_loc.length; j++) {
                if (stall_loc[j] - stall_loc[i] == dist ) return true;
                else if (stall_loc[j] - stall_loc[i] > dist) break;
                else continue;
            }
        }
        return false;
    }

    public static int count(int[] arr, int dist) {

        int cnt = 1; //배치한 말의 마리수
        int ep = arr[0]; //왜???
        for(int i=1; i<arr.length; i++) {
            if(arr[i]-ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;

    }

    public static int getMaxDistanceBetweenShortest(int num_of_stall, int num_of_horse, int[] stall_loc) {

        int lt;
        int rt;
        int answer = -1;

        lt = stall_loc[1] - stall_loc[0];
        rt = stall_loc[num_of_stall - 1] - stall_loc[0];

        while(lt<=rt) {
            int mid = (lt + rt)/2;
            //System.out.println("dist : " + dist + " " +  isPossibleDistance(dist,stall_loc));
            if(count(stall_loc,mid) >= num_of_horse) { //배치할 수 있는 마리수가 우리가 넣어야 하는 말의 마리수보다 많거나 같다면
                answer = mid;
                lt = mid+1;
            }
            else {
                rt = mid-1;
            }
        }
        //우리가 구하고자 하는 답의 범위

        return answer;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_of_stall = sc.nextInt();
        int num_of_horse = sc.nextInt();
        int[] stall_loc = new int[num_of_stall];
        for (int i = 0; i<num_of_stall; i++) {
            stall_loc[i] = sc.nextInt();
        }
        Arrays.sort(stall_loc);

        System.out.println(getMaxDistanceBetweenShortest(num_of_stall,num_of_horse,stall_loc));
    }
}
