package algorithm_ex.two_pointer;

import java.util.Scanner;

public class ContinuousNum {

    public static int count(int size, int obj_num, int[] arr) {
        //어디서 시작하는지를 경우의 수로 나누자...
        int sum = 0;
        int count= 0;
        for (int i = 0; i<size; i++) {
            for(int j = i; j<size; j++) {
                if(sum<obj_num) {
                    sum += arr[j];
                    continue;
                }
                break;
            }
            if(sum==obj_num) {
                count++;
            }
            sum = 0;
        }
        return count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int obj_num = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(count(size, obj_num, arr));
    }
}
