package algorithm_ex.greedy;

import java.util.*;

//class Eg implements Comparable<Eg> {
//
//    private int node1;
//    private int node2;
//    private int weight;
//
//    public Eg(int node1, int node2, int weight) {
//        this.node1 = node1;
//        this.node2 = node2;
//        this.weight = weight;
//    }
//
//    public int getNode1() {
//        return node1;
//    }
//
//    public void setNode1(int node1) {
//        this.node1 = node1;
//    }
//
//    public int getNode2() {
//        return node2;
//    }
//
//    public void setNode2(int node2) {
//        this.node2 = node2;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    @Override
//    public int compareTo(Eg eg) {
//        return this.getWeight() - eg.getWeight();
//    }
//
//    @Override
//    public String toString() {
//        return "Eg{" +
//                "node1=" + node1 +
//                ", node2=" + node2 +
//                ", weight=" + weight +
//                '}';
//    }
//}
public class WonderPrim {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int res = 0;

        ArrayList<Eg> egs = new ArrayList<>();
        Set<Integer> sg = new HashSet<>();

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            Eg eg = new Eg(v1, v2, w);
            egs.add(eg);
        }


        int sn = 1; //start node
        sg.add(sn);
        while (sg.size() < v) {
            PriorityQueue<Eg> pq = new PriorityQueue<>();
            for (Eg eg : egs) {

                //서브그룹과 서브그룹이 아닌 두 덩어리 사이를 연결하는 간선이라면 pq에 넣는다.
                if (sg.contains(eg.getNode1()) && !sg.contains(eg.getNode2())) {
                    pq.add(eg);
                } else if (sg.contains(eg.getNode2()) && !sg.contains(eg.getNode1())) {
                    pq.add(eg);
                }
            }
            Eg eg = pq.poll();
            sg.add(eg.getNode1());
            sg.add(eg.getNode2());

            res += eg.getWeight();
        }


        System.out.println(+ res);

    }
}
