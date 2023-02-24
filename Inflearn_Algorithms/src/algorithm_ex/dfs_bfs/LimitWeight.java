package algorithm_ex.dfs_bfs;

import java.util.*;

public class LimitWeight {

    static int lw;
    static int len;
    static ArrayList<Integer> wa;
    static int mw;
    public static void dfs(int w, int idx) {
        if (idx >= len) {
            if (w < lw) {
                mw = Math.max(w, mw);
            }
        } else {
            int cw = wa.get(idx);
            //cw무게를 태운다
            dfs(w + cw, idx + 1);
            //cw무게를 태우지 않는다.
            dfs(w, idx + 1);

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lw = sc.nextInt();
        len = sc.nextInt();
        mw = Integer.MIN_VALUE;
        wa = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            wa.add(sc.nextInt());
        }

        dfs(0, 0);
        System.out.println(mw);

    }

}
