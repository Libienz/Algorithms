package algorithm_ex.dynamic_prog;

import java.util.ArrayList;
import java.util.Scanner;

public class LisDP {

    public static ArrayList<Integer> seq = new ArrayList<>(); //수열 : seq

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt(); //입력 수열의 길이

        //수열 작성
        for (int i = 0; i < size; i++) {

            int num = sc.nextInt();
            seq.add(num);
        }
    }
}
