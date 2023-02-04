package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Eg implements Comparable<Eg> {

    private int node1;
    private int node2;
    private int weight;

    public Eg(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public int getNode1() {
        return node1;
    }

    public void setNode1(int node1) {
        this.node1 = node1;
    }

    public int getNode2() {
        return node2;
    }

    public void setNode2(int node2) {
        this.node2 = node2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Eg eg) {
        return this.getWeight() - eg.getWeight();
    }

    @Override
    public String toString() {
        return "Eg{" +
                "node1=" + node1 +
                ", node2=" + node2 +
                ", weight=" + weight +
                '}';
    }
}
public class WonderMST {

    public static int unf[];
    public static int res = 0;
    public static boolean egMakesCycle(Eg eg) {
        int p1 = findParent(eg.getNode1());
        int p2 = findParent(eg.getNode2());

        if (p1 != p2) {
            return false;
        } else {
            return true;
        }
    }

    public static void union(int p1, int p2) {
        if (p1 >= p2) {
            int tmp = p2;
            p2 = p1;
            p1 = tmp;
        }
        //p1이 p2보다 작도록 스왑 완료
        unf[p2] = p1;

    }

    public static int findParent(int node) {
        if (unf[node] == node) {
            return node;
        } else {
            return unf[node] = findParent(unf[node]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<Eg> egs = new ArrayList<>();
        unf = new int[v + 1];

        for (int i = 0; i < v + 1; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int w = sc.nextInt();
            Eg edge = new Eg(n1, n2, w);

            egs.add(edge);
        }
        Collections.sort(egs);

        System.out.println("egs = " + egs);

        for (Eg eg : egs) {
            if (egMakesCycle(eg)) {
                continue;
            } else {
                res += eg.getWeight();
                int node1 = eg.getNode1();
                int node2 = eg.getNode2();

                union(node1, node2);
            }
        }

        System.out.println("res = " + res);
    }
}
