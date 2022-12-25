package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Rcs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        ArrayList<Integer> aEntry = new ArrayList<>();
        ArrayList<Integer> bEntry = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            aEntry.add(sc.nextInt());
        }
        for (int i = 0; i < cnt; i++) {
            bEntry.add(sc.nextInt());
        }

        for (int i = 0; i < cnt; i++) {
            int a = aEntry.get(i);
            int b = bEntry.get(i);

            switch (a) {
                case 1:
                    if (b == 1) { //a가위 b가위
                        System.out.println("D");
                    } else if (b == 2) { //a가위 b바위
                        System.out.println("B");
                    } else { //a가위 b보
                        System.out.println("A");
                    }
                    break;
                case 2:
                    if (b == 1) { //a바위 b가위
                        System.out.println("A");
                    } else if (b == 2) { //a바위 b바위
                        System.out.println("D");
                    } else { //a바위 b보
                        System.out.println("B");
                    }
                    break;
                case 3:
                    if (b == 1) {//a보 b가위
                        System.out.println("B");
                    } else if (b == 2) { //a보 b바위
                        System.out.println("A");
                    } else { //a보 b보
                        System.out.println("D");
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
