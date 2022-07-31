package recursive;

import java.util.Scanner;

public class RecursiveBin {

    public static void convertToBinaryNum(int num) {

        int q = num/2;
        int r = num%2;
        if (q<=1) {
            System.out.print(q + "" + r);
            return;
        }
        else {
            convertToBinaryNum(q);
            System.out.print(r);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        convertToBinaryNum(num);
    }


}
