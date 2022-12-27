package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonachi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        for (int i = 2; i < cnt; i++) {
            fib.add(fib.get(i - 1) + fib.get(i - 2));
        }

        for (int n : fib) {
            System.out.printf("%d ", n);
        }
    }
}
