package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DupCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean d_flag = false;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i<num; i++) {
            int n = sc.nextInt();
            if (hashMap.containsKey(n)) {
                d_flag = true;
                break;
            }
            hashMap.put(n,1);
        }

        if (d_flag) {
            System.out.println("D");
        }
        else System.out.println("U");
    }
}
