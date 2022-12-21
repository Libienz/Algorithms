package algorithm_ex.two_pointer;

import java.util.Scanner;

public class ContinuousNum {

    public static int count(int size, int obj_num, int[] arr) {
        //어디서 시작하는지를 경우의 수로 나누자...
        //투포인터를 써서 rt를 증가시키고 lt를 쫓아오게 만들면 모든 케이스에 대한 검증이 가능 한지도 의문인데 ..?
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
