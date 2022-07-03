package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Rcs {

    public static char whoWin(int a, int b) {
        if (a == 1) {
            if (b == 1) {
                return 'D';
            }
            else if (b==2) {
                return 'B';
            }
            else {
                return 'A';
            }
        }
        else if (a==2) {
            if (b==1) {
                return 'A';
            }
            else if (b==2) {
                return 'D';
            }
            else {
                return 'B';
            }
        }
        else {
            if (b==1) {
                return 'B';
            }
            else if (b==2) {
                return 'A';
            }
            else {
                return 'D';
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a_pattern = new ArrayList<>();
        ArrayList<Integer> b_pattern = new ArrayList<>();

        int size = sc.nextInt();
        for (int i = 0; i<size; i++) {
            a_pattern.add(sc.nextInt());
        }
        for (int i = 0; i<size; i++) {
            b_pattern.add(sc.nextInt());
        }
        for (int i =0; i<size; i++) {
            System.out.println(whoWin(a_pattern.get(i),b_pattern.get(i)));
        }

    }
}
