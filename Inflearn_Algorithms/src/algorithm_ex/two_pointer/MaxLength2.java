package algorithm_ex.two_pointer;

import java.util.Scanner;

public class MaxLength2 {

    public static int getMaxLengthOfOne(int length, int chance, int[] arr) {
        int lt = 0;
        int chance_cnt = 0;
        int max_len = 0;
        for (int rt = 0; rt<length; rt++) {
            if (arr[rt] == 0) chance_cnt++;
            while(chance_cnt>chance) {
                if(arr[lt] == 0) chance_cnt--;
                lt++;
            }
            max_len = Math.max(max_len,rt-lt+1);
        }
        return max_len;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int chance = sc.nextInt(); //바꿀 수 있는 기회
        int[] arr = new int[length];
        for (int i = 0; i<length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getMaxLengthOfOne(length,chance,arr));
    }
}
