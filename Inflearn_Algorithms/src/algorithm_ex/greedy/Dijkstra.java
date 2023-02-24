package algorithm_ex.greedy;

import java.util.*;

class Edge {
    int sn;
    int fn;
    int w;

    public Edge(int sn, int fn, int w) {
        this.sn = sn;
        this.fn = fn;
        this.w = w;
    }
}
public class Dijkstra {

    public static boolean allChecked(ArrayList<Boolean> check) {
        for (boolean bool : check) {
            if (!bool) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //정점 수
        int m = sc.nextInt(); //간선 수

        ArrayList<Edge> arr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int sn = sc.nextInt();
            int fn = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Edge(sn-1, fn-1, w));
        }

        ArrayList<Integer> distance = new ArrayList<>();
        ArrayList<Boolean> check = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            distance.add(Integer.MAX_VALUE);
            check.add(false);
        }

        //start
        distance.set(0, 0);


        while (!allChecked(check)) {

            //distance배열에서 최솟값 찾는다.
            System.out.println("distance = " + distance);
            int ld = Integer.MAX_VALUE;
            int li = -1;
            for (int i = 0; i < distance.size(); i++) {
                int cur = distance.get(i);
                if (cur <= ld && !check.get(i)) {
                    li = i;
                    ld = cur;
                }

            }

            //1번 노드에서 li노드로 가는 거리는 확정
            System.out.println("li = " + li);
            check.set(li, true);
            //li에서 갈 수 있는 곳들을 추가한다.
            if (distance.get(li) == Integer.MAX_VALUE) {
                continue;
            }
            for (Edge e : arr) {
                if (e.sn == li) {
//                    distance.set(e.fn, distance.get(li) + e.w);
                    int ndis = distance.get(li) + e.w;
                    Integer odis = distance.get(e.fn);
                    if (ndis < odis) {
                        distance.set(e.fn, ndis);
                    }
//                    System.out.println(distance.get(li));

                }
            }
        }

        System.out.println("distance = " + distance);

    }
}
