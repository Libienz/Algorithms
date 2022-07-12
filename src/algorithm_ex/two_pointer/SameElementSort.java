package algorithm_ex.two_pointer;

import java.util.*;

public class SameElementSort {
    public static ArrayList<Integer> solution(int[] a_arr, int[] b_arr) {
        int a_lt=0;
        int b_lt=0;
        ArrayList<Integer> res_arr = new ArrayList<>();
        while(a_lt<a_arr.length && b_lt<b_arr.length) {
            if(a_arr[a_lt] < b_arr[b_lt]) a_lt++;
            else if(a_arr[a_lt] > b_arr[b_lt]) b_lt++;
            else {
                res_arr.add(a_arr[a_lt]);
                a_lt++;
                b_lt++;
            }
        }
        while(a_lt<a_arr.length) {
            if(a_arr[a_lt] != b_arr[b_arr.length-1]) a_lt++;
            else res_arr.add(b_arr[b_arr.length-1]);
        }
        while(b_lt<b_arr.length) {
            if(b_arr[b_lt] != a_arr[a_arr.length-1]) b_lt++;
            else res_arr.add(a_arr[a_arr.length-1]);
        }


        return res_arr;
    }

    private static void quickSort(int[] arr,int start, int end) {
        int part=partition(arr,start,end);
        if(start<part-1) quickSort(arr,start,part-1);
        if(end>part) quickSort(arr,part,end);
    }

    private static int partition(int[] arr,int start,int end) {
        int pivot=arr[(start+end)/2];
        while(start<=end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if(start<=end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr,int start,int end) {
        int tmp=arr[start];
        arr[start]=arr[end];
        arr[end]=tmp;
        return;
    }

    public static void bubbleSort(ArrayList<Integer> arr) {
        for (int i = 0; i<arr.size(); i++) {
            for (int j = 0; j<arr.size()-i-1; j++) {
                if (arr.get(j)> arr.get(j+1)) {
                    int tmp = arr.get(j);
                    arr.set(j,arr.get(j+1));
                    arr.set(j+1,tmp);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size_of_a = sc.nextInt();
        int[] a_arr = new int[size_of_a];
        for (int i = 0; i<size_of_a; i++) {
            a_arr[i] = sc.nextInt();
        }
        quickSort(a_arr,0,a_arr.length-1);
        int size_of_b = sc.nextInt();
        int[] b_arr = new int[size_of_b];
        for (int i = 0; i<size_of_b; i++) {
            b_arr[i] = sc.nextInt();
        }
        quickSort(b_arr,0,b_arr.length-1);

        ArrayList<Integer> res = solution(a_arr, b_arr);
        for (int i = 0; i<res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
/*
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : b_arr) {
            if(a_arr.contains(num)) {
                res.add(num);
            }
        }
*/


        //ArrayList<Integer> res = solution(a_arr, b_arr);

/*        bubbleSort(res);
        for (int i = 0; i<res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }*/

    }
}
