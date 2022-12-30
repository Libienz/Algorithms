package algorithm_ex.two_pointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwoPointSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            arr1.add(sc.nextInt());
        }

        int size2 = sc.nextInt();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < size2; i++) {
            arr2.add(sc.nextInt());
        }


        int index1 = 0;
        int index2 = 0;

        ArrayList<Integer> res = new ArrayList<>();
        while (index1 < arr1.size() && index2 < arr2.size()) {
            if (arr1.get(index1) > arr2.get(index2)) {
                res.add(arr2.get(index2));
                index2++;
            } else {
                res.add(arr1.get(index1));
                index1++;
            }
        }
        if (index1 == size1) {
            for (int i = index2; i < size2; i++) {
                res.add(arr2.get(i));
            }
        } else if (index2 == size2){
            for (int i = index1; i < size1; i++) {
                res.add(arr1.get(i));
            }
        }

        for (int num : res) {
            System.out.print(num + " ");

        }
    }
}
