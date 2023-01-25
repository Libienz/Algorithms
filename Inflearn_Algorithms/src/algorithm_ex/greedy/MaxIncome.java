package algorithm_ex.greedy;

import java.util.*;

class Request implements Comparable<Request>{
    private int reward;
    private int due;

    public Request(int reward, int due) {
        this.reward = reward;
        this.due = due;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }

    @Override
    public String toString() {
        return "Request{" +
                "reward=" + reward +
                ", due=" + due +
                '}';
    }

    @Override
    public int compareTo(Request o) {
        if (this.due == o.due) {
            return o.reward - this.reward;
        }
        return o.due - this.due;
    }
}
public class MaxIncome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Request> arr = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr.add(new Request(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(arr);
//        System.out.println("arr = " + arr);
        int res = 0;
        int mDue = arr.get(0).getDue();
        int idx = 0;
        //i일에 할 수 있는 강연 중 가장 페이가 쎈 것을 찾자
        for (int i = mDue; i >= 1; i--) {
            for (int j = idx; j < size; j++) {
                if (arr.get(j).getDue() == i) {
                    pq.offer(arr.get(j).getReward());
                } else {
                    idx = j;
                    break;
                }
            }
//            System.out.println("pq = " + pq);
            //보상이 제일 큰 것 선택
            if (pq.isEmpty()) {
                continue;
            }
            res += pq.poll();
        }

        System.out.println(res);

    }
}
