package recursive;

import java.util.Scanner;

public class RecursiveFunc {


    public static void printAll(int num, int start) {

        if (start>num) {
            return;
        }
        System.out.print(start+" ");
        printAll(num, start+1);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printAll(num, 1);
    }


}
