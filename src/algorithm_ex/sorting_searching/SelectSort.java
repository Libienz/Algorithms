package algorithm_ex.sorting_searching;

import java.util.Scanner;

public class SelectSort {

    //정수형 배열인 arr에서 특별지정한 start index부터 순회하며 최솟값을 찾는다.
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

    //선택 정렬 : 최솟값을 찾아나가며 왼쪽부터 정렬한다.
    //루프 예시 :
        //첫번째 루프 : arr[0] 하고 0번부터 arr의 끝까지 중 가장 작은 수와 스왑. 배열의 맨 왼쪽이 정렬된 상태
        //두번째 루프 : arr[1] 하고 1번부터 arr의 끝까지 중 가장 작은 수와 스왑. 배열의 1번 인덱스까지 정렬된 상태
        //세번째 루프 : arr[2] 하고 2번부터 arr의 끝까지 중 가장 작은 수와 스왑. 배열의 2번 인덱스까지 정렬된 상태
        // .....
    //문제는 왜 스왑이 안먹힘? 스왑 왜안됨 이 tlqkf 거꾸로 하면 왜 됨?
    public static void selectSort(int[] arr) {

  /*      for (int i = 0; i<arr.length; i++) {
            int tmp = arr[getMinInd(arr,i)];
            arr[getMinInd(arr,i)] = arr[i];
            arr[i] = tmp;
        }
*/
        for (int i = 0; i<arr.length; i++) {
            int tmp = arr[i];
            arr[i] = arr[getMinInd(arr,i)];
            arr[getMinInd(arr,i)] = tmp;
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
