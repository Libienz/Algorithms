package algorithm_ex.two_pointer;

import java.util.*;
//애초에 그리디 알고리즘으로 푸는 문제가 아닌가 ..? -> 거의 확신 이거인듯 .. 그러면 ... 모든 경우의 수 대입 비교 ..? 찬스에 따라서 조합으로 뽑을 수 있는 모든 경우의 수 넣나 ..?  말이 안되는 데..
public class MaxLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int chance = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Boolean> used = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
            used.add(false);
        }

        for (int i = 0; i < chance; i++) {
            for (int j = 0; j < size; j++) {
                if (used.get(j)) {

                }
            }
        }
    }
}

/*
package algorithm_ex.two_pointer;

import java.util.*;
//애초에 그리디 알고리즘으로 푸는 문제가 아닌가 ..? -> 거의 확신 이거인듯 .. 그러면 ... 모든 경우의 수 대입 비교 ..? 찬스에 따라서 조합으로 뽑을 수 있는 모든 경우의 수 넣나 ..?  말이 안되는 데..
public class MaxLength {

    public static int countLengthOfOne(int[] arr) { //여기 잘못 ... 아닌데.. -> ㄴㄴ 여기가 잘못임 0이 나와서 끝나는 경우만 생각하고 끝까지 가서 끝나는 경우 놓침 -> 고쳤는데도 오답,,
        int count = 0;
        int max = 0;
        for(int i = 0; i<arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
            else {
                if (count > max) max = count;
                count = 0;
                continue;
            }
        }
        if (count > max) max = count;
        return max;
    }
    public static int getIndexOfMax(List<Integer> arr) {
        int max = 0;
        int index_of_max_num = -1;
        for (int i =0; i<arr.size(); i++) {
            if (arr.get(i)>max) {
                max = arr.get(i);
                index_of_max_num = i;
            }

        }
        return index_of_max_num;
    }
    public static int howManyOneAround(int index, int[] arr) {
        int count = 0;
        //왼쪽으로 연속된 1의 개수
        for (int i = index-1; i>=0; i--) {
            if (arr[i] == 1) count++;
            else break;
        }
        //오른쪽으로 연속된 1의 개수
        for (int i = index+1; i<arr.length; i++) {
            if (arr[i] == 1) count++;
            else break;
        }
        return count;
    }
    //바꾸기 제일 좋은 자리는 어디? 앞뒤로 연속된 1이 가장 많은 곳 찬스만큼 그리디 하게 먹는 알고리즘인데 이게 틀렸나 ..?
    public static int getMaxLengthOfOne(int length, int chance, int[] arr) {

        List<Integer> index_of_zero = new ArrayList<>(); //0의 위치들
        List<Integer> how_many_one_arround = new ArrayList<>(); //주변 1의 개수
        for (int j = 0; j<chance; j++) {
            for (int i = 0; i<length; i++) {
                if (arr[i] == 0) {
                    index_of_zero.add(i);
                    how_many_one_arround.add(howManyOneAround(i,arr));
                }
            }
            if(index_of_zero.isEmpty()) {
                break;
            }
            arr[index_of_zero.get(getIndexOfMax(how_many_one_arround))] = 1; //후보 최우선 순위 1로 변경완료
            index_of_zero.clear();
            how_many_one_arround.clear();
        }
        /*for (int i = 0; i<length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println("");*/
/*
        return countLengthOfOne(arr);


                }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int chance = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i<length; i++) {
        arr[i] = sc.nextInt();
        }
        System.out.println(getMaxLengthOfOne(length,chance,arr));
        }
        }

        */