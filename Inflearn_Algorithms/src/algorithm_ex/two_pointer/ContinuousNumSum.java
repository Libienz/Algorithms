package algorithm_ex.two_pointer;

import java.util.Scanner;

public class ContinuousNumSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int objNum = sc.nextInt();

        int cnt = 0;

        for (int i = 1; i <= objNum / 2; i++) {
            int subSum = 0;
            for (int j = i; j < objNum; j++) {
                subSum += j;
                if (subSum == objNum) {
                    cnt++;
                    break;
                }
                if (subSum > objNum) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
