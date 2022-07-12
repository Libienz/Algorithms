package algorithm_ex.two_pointer;

import java.util.Scanner;

public class ContinuousNumSum {
    public static int count(int obj_num) {
        int count = 0;
        int sum = 0;
        int start_num = 0;
        for (int i =1; i<=(obj_num/2) ; i++) {
            start_num = i;
            while(sum < obj_num) {
                sum = sum + start_num++;
            }
            if (sum == obj_num) {
                count++;
            }
            sum = 0;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int obj_num = sc.nextInt();
        System.out.println(count(obj_num));
    }
}
