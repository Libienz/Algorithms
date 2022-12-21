package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonachi {

    public static void getFib(int size) {
        ArrayList<Integer> fib_arr = new ArrayList<>();
        fib_arr.add(1);
        fib_arr.add(1);

        for (int i = 2; i<size; i++) {
            fib_arr.add(fib_arr.get(i-2)+fib_arr.get(i-1));
        }
        for (int i=0; i<size; i++) {
            System.out.print(fib_arr.get(i)+" ");
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        getFib(size);
    }
}
