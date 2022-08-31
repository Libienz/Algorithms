package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Edge1 implements Comparable<Edge1> {
    private int s;
    private int f;
    private int w;

    public Edge1(int s, int f, int w) {
        this.s = s;
        this.f = f;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Edge1{" +
                "s=" + s +
                ", f=" + f +
                ", w=" + w +
                '}';
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    @Override
    public int compareTo(Edge1 o) {
        return this.w - o.w; //오름차순 this에서 빼기
    }
}
public class WonderMST {

    //public static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    public static ArrayList<Edge1> e_arr = new ArrayList<>();
    public static int[] unf;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // 도시의 개수
        int e = sc.nextInt(); // 도로의 개수

        unf = new int[v + 1];

        for (int i = 0; i < unf.length; i++) {
            unf[i] = i;
        }

        /*for (int i = 0; i <= v; i++) {
            graph.add(i, new ArrayList<>());
        }*/

        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int finish = sc.nextInt();
            int weight = sc.nextInt();
            //graph.get(start).add(new Edge(finish, weight));
            e_arr.add(new Edge1(start, finish, weight));
        }

        //간선 가중치의 오름차순으로 정렬 CompartTo 활용
        Collections.sort(e_arr);
        int sum = 0;
        for (Edge1 e1 : e_arr) {
            if (isTriggerCycle(e1)) {
                continue;
            }
            else {
                union(e1.getS(), e1.getF());
                sum += e1.getW();
            }
        }

        System.out.println(sum);




    }

    private static void union(int s, int f) {
        int fa = find(s);
        int fb = find(f);

        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int find(int s) {
        if (s == unf[s]) {
            return unf[s];
        }
        else {
            return find(unf[s]);
        }
    }
    private static boolean isTriggerCycle(Edge1 e1) {
        if (find(e1.getS()) == find(e1.getF())) {
            return true;
        }
        else {
            return false;
        }
    }
}
