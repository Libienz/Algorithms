package algorithm_ex.two_pointer;

import java.util.*;

public class SameElementSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size1 = sc.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }
        Arrays.sort(arr1);

        int size2 = sc.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        Arrays.sort(arr2);

        int index1 = 0;
        int index2 = 0;


        ArrayList<Integer> res = new ArrayList<>();
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] == arr2[index2]) {
                res.add(arr1[index1]);
                index2++;
                index1++;
            } else if (arr1[index1] < arr2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        for (int num : res) {
            System.out.print(num+ " ");
        }
    }
}
