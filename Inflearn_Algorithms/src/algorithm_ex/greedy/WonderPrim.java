package algorithm_ex.greedy;

import java.util.*;

/**
 * 해당 간선은 v로 가는데 cost가 w다.
 * 출발 점은? 인접 리스트로 만들 것이기에 인덱스 번호가 된다.
 */
class Edg implements Comparable<Edg> {


    private int v;
    private int w;

    public Edg(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    @Override
    public String toString() {
        return "Edg{" +
                "v=" + v +
                ", w=" + w +
                '}';
    }

    @Override
    public int compareTo(Edg eg) {
        return this.getW() - eg.getW();
    }

}

public class WonderPrim {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int vNum = sc.nextInt();
        int eNum = sc.nextInt();
        boolean[] check = new boolean[vNum + 1];
        ArrayList<ArrayList<Edg>> graph = new ArrayList<>(); //인접 리스트 -> 1번 인덱스에 들어있는 배열의 정체는 1번 인덱스로 부터 뻗어나가는 간선들
        PriorityQueue<Edg> pq = new PriorityQueue<>();

        for (int i = 0; i < vNum + 1; i++) {
            graph.add(new ArrayList<>());
            check[i] = false;
        }

        for (int i = 0; i < eNum; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            graph.get(v2).add(new Edg(v1, w));
            graph.get(v1).add(new Edg(v2, w));
        }


        int sn = 1; //출발 노드는 1번
//        check[1] = true; //1번은 방문 했음 재방문 하려 한다면 그것은 cycle

        //1번으로 가는 코스트는 0
        pq.add(new Edg(1, 0));

        int res = 0;
        while (!pq.isEmpty()) {
//            System.out.println("pq = " + pq);
            Edg poll = pq.poll();
            if (check[poll.getV()]) {
                continue;
            }
            //poll은 서브 그래프와 서브그래프가 아닌 두 그래프 사이를 잇는 간선 중 가중치가 최소인 간선
            //greedy하게 최소 가중치의 간선을 뽑는다
            //뽑았다면 그것은 서브 그래프와 서브그래프가 아닌 부분을 잇는 MST에 일부분이 될 수 밖에 없는 간선임
            check[poll.getV()] = true;
            res += poll.getW();

            //뽑은 간선의 목적지에서 서브그래프에 포함되지 않는 부분과 연결되는 간선들을 다시 pq에 add
            for (Edg edg : graph.get(poll.getV())) {
                if (!check[edg.getV()]) {
                    pq.offer(edg);
                }
            }

        }
        System.out.println(res);

    }

}
