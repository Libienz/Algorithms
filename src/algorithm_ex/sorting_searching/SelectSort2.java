package algorithm_ex.sorting_searching;

import java.util.Scanner;

public class SelectSort2 {

    //이것도 거꾸로 하면 왜 안됨 ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????

    public static void swap(int[] arr,int i,int j) {
        int tmp;
        tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
    public static int getMinInd(int[] arr, int start) {

        int min = Integer.MAX_VALUE;
        int min_ind = -1;
        for (int i = start; i<arr.length; i++) {
            if (arr[i] < min) {
                min_ind = i;
                min = arr[i];
            }
        }
        return min_ind;
    }
    public static void selectSort(int[] arr) {

        for (int i = 0; i<arr.length; i++) {
            /*int tmp = arr[i];*/
            //System.out.println("i : " + i + " min_ind : " + getMinInd(arr,i));
            /*arr[i] = arr[getMinInd(arr,i)];
            arr[getMinInd(arr,i)] = tmp;*/
            swap(arr,i,getMinInd(arr,i));
            //System.out.println(arr[i] + " " + arr[getMinInd(arr,i)]);
        }

        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        selectSort(arr);

/*        for (int i = 0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }*/
    }
}
