package algorithm_ex.stack_queue;

import java.util.Scanner;

public class SaveDeer {

    public static int chosenPrince(int num, int k) {


        int left_prince = num;
        int[] prince = new int[num + 1];
        prince[0] = 0;
        int count = 0;
        for (int i = 1; i<prince.length; i++) {
            prince[i] = 1;
        }
        while(left_prince > 1) {
            for(int i = 1; i<prince.length; i++) {
                if (prince[i] == 0) {
                    continue;
                }
                else {
                    count++;
                    if (count ==k) {
                        prince[i] = 0;
                        count = 0;
                        left_prince--;
                    }
                }
            }


        }

        for (int i = 1; i<prince.length+1; i++) {
            if (prince[i] == 1) {
                return i;
            };
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();


        System.out.println(chosenPrince(num, k));
    }
}
