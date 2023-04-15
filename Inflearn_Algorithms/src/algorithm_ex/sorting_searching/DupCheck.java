package algorithm_ex.sorting_searching;

import java.util.*;

public class DupCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int num = sc.nextInt();
            set.add(num);
        }
        if (set.size() < size) {
            System.out.println("D");
        } else {
            System.out.println("U");
        }
    }
}
