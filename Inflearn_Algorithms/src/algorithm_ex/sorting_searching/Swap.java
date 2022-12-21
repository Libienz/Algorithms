package algorithm_ex.sorting_searching;

public class Swap {
    public static void main(String[] args) {
        int [] arr = new int[5];

        for (int i =0; i<arr.length; i++) {
            arr[i] = i;
        }

        int tmp = arr[1];
        arr[1] = arr[0];
        arr[0] = tmp;
        for (int num : arr) {
            System.out.print(num +" ");
        }
    }
}
