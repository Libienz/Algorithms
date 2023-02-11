package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Rcs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> aE = new ArrayList<>(); //A entry
        ArrayList<Integer> bE = new ArrayList<>(); //B entry

        int n = sc.nextInt(); //n번의 가위바위보
        for (int i = 0; i < n; i++) {
            aE.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            bE.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            Integer a = aE.get(i);
            Integer b = bE.get(i);

            switch (a) {
                case 1: //a 가위
                    if (b == 1) { //b 가위
                        System.out.println("D");
                    } else if (b == 2) { //b 바위
                        System.out.println("B");
                    } else if (b == 3) { //b 보
                        System.out.println("A");
                    } else { //오류
                        System.out.println("B가 가위 바위 보 중 하나를 내지 않았습니다.");
                    }
                    break;
                case 2: //a 바위
                    if (b == 1) { //b 가위
                        System.out.println("A");
                    } else if (b == 2) { //b 바위
                        System.out.println("D");
                    } else if (b == 3) { //b 보
                        System.out.println("B");
                    } else { //오류
                        System.out.println("B가 가위 바위 보 중 하나를 내지 않았습니다.");
                    }
                    break;
                case 3: //a 보
                    if (b == 1) { //b 가위
                        System.out.println("B");
                    } else if (b == 2) { //b 바위
                        System.out.println("A");
                    } else if (b == 3) { //b 보
                        System.out.println("D");
                    } else { //오류
                        System.out.println("B가 가위 바위 보 중 하나를 내지 않았습니다.");
                    }
                    break;
                default:
                    System.out.println("A가 가위 바위 보 중 하나를 내지 않았습니다.");

            }
        }
    }
}
