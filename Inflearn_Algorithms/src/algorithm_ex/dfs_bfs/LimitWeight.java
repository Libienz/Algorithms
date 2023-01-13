package algorithm_ex.dfs_bfs;

import java.util.*;

public class LimitWeight {

    static int size, cp;
    static int max = Integer.MIN_VALUE;

    static ArrayList<Integer> arr = new ArrayList<>();

    public static void dfs(int idx, int sum) {
        if (idx >= size) {
            if (sum > cp) {
                return;
            }
            if (max < sum) {
                max = sum;
            }
            return;
        }
        //idx 강아지를 태운다
        Integer dw = arr.get(idx);
        dfs(idx + 1, sum + dw);
        //태우지 않는다.
        dfs(idx + 1, sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cp = sc.nextInt(); //capacity
        size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
        }

        dfs(0, 0);
        System.out.println(max);

    }

}
