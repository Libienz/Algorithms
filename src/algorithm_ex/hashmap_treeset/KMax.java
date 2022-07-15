package algorithm_ex.hashmap_treeset;

import java.util.*;

/*
1. 첫번째 큰값 그리디하게 뽑아낸다.
2. 해당 값들 pop
3. 두번째 큰값 그리디하게 뽑아낸다.
4. 해당 값 pop .... 요거 3번까지
*/
public class KMax {

    public static int getKth(int num, int k, int[] arr) {

        if(num<k) return -1;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i<=num-3; i++) {
            for (int j = i+1; j<= num-2; j++) {
                for (int t = j+1; t<=num-1; t++) {
                    int sum = arr[i] + arr[j] + arr[t];
                    set.add(sum);
                }
            }
        }
        int answer = 0;
        if (set.size()<3) return -1;
        for (int i = 0; i<k; i++) {
            //i+1번째
            answer = Collections.max(set);
            set.remove(answer);
        }
        return answer;
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getKth(num, k, arr));
    }
}
