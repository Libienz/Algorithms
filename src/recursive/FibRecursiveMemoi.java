package recursive;

import java.util.Scanner;



public class FibRecursiveMemoi {

    static int[] memoi;


    public static int getFib(int num) {


        if (num == 1 || num == 2) {
            return 1;
        }
        else if (memoi[num] != 0) {
            return memoi[num];
        }
        else {
            int n1 = getFib(num - 1);
            int n2 = getFib(num - 2);
            memoi[num - 1] = n1;
            memoi[num - 2] = n2;

            return n1 + n2;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        memoi  = new int[num + 1];
        memoi[1] = 1;
        memoi[2] = 1;
        for (int i = 1; i <= num; i++) {
            System.out.println(getFib(i));
        }
    }
}
