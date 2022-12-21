package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintMax {
/*
    N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
*/
    public static void compare(List<Integer> num_list) {
        System.out.print(num_list.get(0));
        for (int i= 0; i<num_list.size()-1; i++) {
            if (num_list.get(i) < num_list.get(i+1)) {
                System.out.print(" "+ num_list.get(i+1));
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> num_list = new ArrayList<Integer>();
        int size = sc.nextInt();
        for(int i = 0; i<size; i++) {
            num_list.add(sc.nextInt());
        }
        /*
        for (int i= 0; i<num_list.size(); i++) {
            System.out.println(num_list.get(i));
        }
        */
        //배열완성
        compare(num_list);
    }
}
