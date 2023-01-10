package algorithm_ex.sorting_searching;

import java.util.*;

public class Tricker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> tArr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = sc.nextInt();
            arr.add(num);
            tArr.add(num);
        }

        Collections.sort(arr);

        for (int i = 0; i < size; i++) {
            int arrIdx = arr.get(i);
            int tArrIdx = tArr.get(i);
            if (arrIdx != tArrIdx) {
                System.out.print(i+1 +" ");
//                System.out.println("arr: " + arr.get(i));
//                System.out.println("tArr: " + tArr.get(i));
            }
        }
//        System.out.println();
//
//        System.out.println(arr);
//        System.out.println(tArr);
    }
}
