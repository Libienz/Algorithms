package algorithm_ex.greedy;

import java.util.*;

class Spec {
    private int w;
    private int h;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Spec(int w, int h) {
        this.w = w;
        this.h = h;
    }
}
public class Wrestling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Spec> arr = new ArrayList<>();
        int res = 0;
        boolean p = true;

        for (int i = 0; i < size; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Spec(w, h));
        }

        for (int i = 0; i < size; i++) {
            Spec cur = arr.get(i);
            //cur가 선발될 수 있는지 알아보자
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                Spec comp = arr.get(j);
                if (cur.getH() < comp.getH() && cur.getW() < comp.getW()) {
                    //탈락
                    p = false;
                    break;
                }
            }
            if (p) {
                res++;
            }
            p = true;


        }
        System.out.println(res);
    }
}

