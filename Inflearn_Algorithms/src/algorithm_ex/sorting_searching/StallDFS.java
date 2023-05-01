package algorithm_ex.sorting_searching;

import java.util.*;

public class StallDFS {


    static int n;
    static int c;
    static int[] sp;
    static ArrayList<Integer> hs;
    static ArrayList<Integer> ha;

    // 0 - n-1 까지의 숫자 중에서 c개를 뽑기
    public static void dfs(int lc, int idx) {

        if (lc == 0) {
            //hs에는 선택한 마굿간의 좌표가 들어있음
            int mbt = Integer.MAX_VALUE; // min between two horse 가장 가까운 두 말의 거리
            Collections.sort(hs);
//            System.out.println("hs = " + hs);
            for (int i = 0; i < hs.size() - 1; i++) {
                int h1 = hs.get(i);
                int h2 = hs.get(i + 1);

                if ((h2 - h1) < mbt) {
                    mbt = h2 - h1;
                }
            }
            ha.add(mbt);
        }
        else {
            for (int i = idx; i < n; i++) {

                //i를 초이스 한다.
                hs.add(sp[i]); //hs에는 선택한 마굿간의 좌표가 들어있음
//                System.out.println("sp[i] = " + sp[i]);
                dfs(lc - 1, i + 1);
                //i를 초이스 하지 않는다.
                hs.remove((Object) sp[i]);
//                dfs(lc - 1, i + 1);
            }

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //n개의 마굿간이 수직선상에 있다.
        c = sc.nextInt(); //현수는 c마리의 말을 가지고 있다.

        sp = new int[n]; //n개의 마굿간의 좌표들이 들어있다.
        hs = new ArrayList<>();
        ha = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sp[i] = sc.nextInt(); //sp[i]는 i번째 마굿간의 수직선상 위치
        }

        //가장 가까운 두 말의 거리가 최대가 되게 말을 배치
        //dfs 적 풀이
        dfs(c, 0);

        Collections.sort(ha);
        System.out.println(ha.get(ha.size() - 1));

    }
}
