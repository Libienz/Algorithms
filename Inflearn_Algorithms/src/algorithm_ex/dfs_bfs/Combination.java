package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Combination {

    static int n, m;
    static ArrayList<Integer> comb;
    //num -> 하나를 뽑고 그 이후에 뽑는 것들은 1부터 다시 단계를 거치지 않는다.
    //조합은 순서를 고려하지 않음 즉, 1,2 와 2,1은 하나의 조합임
    //따라서 하나를 뽑았으면 그 이전에 것들은 돌아볼 필요가 음슴
    public static void dfs(int ch, int num) {
        if (ch == m) {
            System.out.println(comb);
            return;
        } else {
            for (int i = num; i <= n; i++) {
                //i를 뽑는다.
                if (comb.contains(i)) {
                    continue;
                }
                comb.add(i);
                dfs(ch + 1,i+1);
                //i를 뽑지 않는다.
                comb.remove((Object) i);
//                dfs(ch);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //n개중에
        m = sc.nextInt(); //m개를 뽑는 경우의 수 구하기
        comb = new ArrayList<>();
        dfs(0,1);
        //nCm

    }
}
