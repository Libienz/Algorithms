package algorithm_ex.greedy;

import java.util.*;

class Request2 implements Comparable<Request2>{
    private int fee;
    private int dline;
    private boolean is_last = false;

    @Override
    public String toString() {
        return "Request2{" +
                "fee=" + fee +
                ", dline=" + dline +
                '}';
    }

    public void setIs_last(boolean is_last) {
        this.is_last = is_last;
    }

    public int getFee() {
        return fee;
    }

    public boolean isIs_last() {
        return is_last;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getDline() {
        return dline;
    }

    public void setDline(int dline) {
        this.dline = dline;
    }

    public Request2(int fee, int dline) {
        this.fee = fee;
        this.dline = dline;
    }

    @Override
    public int compareTo(Request2 o) {
        return o.getDline() - this.getDline(); //일수 내림차순
    }
}
public class MaxIncome2 {

    public static int getMaxIncome(List<Request2> req_arr) {

        int day = req_arr.get(0).getDline();
        int fee_sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //내림차순 큰게 우선

        for (int i = 0; i<req_arr.size(); i++) {
            Request2 cur = req_arr.get(i);
            if (cur.getDline() == day) {
                pq.add(cur.getFee());
                //System.out.println(r.getFee());
            }
            else {
                if (!pq.isEmpty()) {
                    fee_sum += pq.poll();
                }
                day--;
                i--;
            }
        }
        if (day>=1 && !pq.isEmpty()) {
            fee_sum += pq.poll();
        }




        return fee_sum;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Request2> req_arr = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int fee = sc.nextInt();
            int day = sc.nextInt();
            Request2 request = new Request2(fee, day);
            req_arr.add(request);

        }

        Collections.sort(req_arr);
        System.out.println(getMaxIncome(req_arr));



    }
}
