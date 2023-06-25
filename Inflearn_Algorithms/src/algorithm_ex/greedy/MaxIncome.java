package algorithm_ex.greedy;

import java.util.*;

class Request implements Comparable<Request> {
    int m;
    int d;

    public Request(int m, int d) {
        this.m = m;
        this.d = d;
    }



    @Override
    public String toString() {
        return "Request{" +
                "m=" + m +
                ", d=" + d +
                '}';
    }

    @Override
    public int compareTo(Request o) {

        return o.m - this.m;
    }
}
public class MaxIncome {

    public static void main(String[] args) {

        ArrayList<Request> arr = new ArrayList<>();
        PriorityQueue<Request> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n개의 기업이 강연 요청을 했다.
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt(); //m만큼의 강연료를 주겠다.
            int d = sc.nextInt(); //d일 안에 와서 강의 해주면
            Request request = new Request(m, d);
            arr.add(request);
        }


        int maxD = Integer.MIN_VALUE;
        for (Request r : arr) {
            if (r.d > maxD) {
                maxD = r.d;
            }
        }


        int res = 0;
        for (int i = maxD; i > 0; i--) {
            for (Request r : arr) {
                if (r.d == i) {
                    pq.add(r);
                }
            }
            if (pq.isEmpty()) {
                continue;
            }
            res += pq.poll().m;
            //i일 째에 할 수 있는 강연
        }

        System.out.println(res);

    }
}
