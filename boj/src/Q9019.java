import java.util.*;

class Calculator {

    public static int d(int reg) {
        reg *= 2;
        if (reg >= 10000) {
            reg = reg % 10000;
        }
        return reg;
    }

    public static int s(int reg) {
        if (reg == 0) {
            return 9999;
        }
        return reg - 1;
    }

    public static int l(int reg) {
        int d1 = reg / 1000;
        int d2 = reg / 100 - d1 * 10;
        int d3 = reg / 10 - d1 * 100 - d2 * 10;
        int d4 = reg / 1 - d1 * 1000 - d2 * 100 - d3 * 10;
        reg = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
        return reg;

    }

    public static int r(int reg) {
        int d1 = reg / 1000;
        int d2 = reg / 100 - d1 * 10;
        int d3 = reg / 10 - d1 * 100 - d2 * 10;
        int d4 = reg / 1 - d1 * 1000 - d2 * 100 - d3 * 10;
        reg = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
        return reg;
    }


}
//해당 숫자가 현재까지 거친 연산 기록을 가지는 객체
class HistoryInteger {
    private String opHistory;
    private int num;

    public HistoryInteger(int num, String opHistory) {
        this.opHistory = opHistory;
        this.num = num;
    }

    public String getOpHistory() {
        return opHistory;
    }

    public void setOpHistory(String opHistory) {
        this.opHistory = opHistory;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

public class Q9019 {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //t개의 test case

        //test case들을 이차원 배열에 저장
        ArrayList<ArrayList<Integer>> cases = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            ArrayList<Integer> tc = new ArrayList<>();
            tc.add(sc.nextInt());
            tc.add(sc.nextInt());
            cases.add(tc);
        }

        //각 케이스별로 첫번째 숫자를 두번째 숫자로 옮기기 위한 최소 연산을 찾는다.
        for (ArrayList<Integer> tc : cases) {

            int in = tc.get(0);
            int out = tc.get(1);
            boolean[] visited = new boolean[10001];
            for (int i = 0; i < visited.length; i++) {
                visited[i] = false;
            }
            //in에서 out으로 되기 위한 최소 연산을 구하자
            Queue<HistoryInteger> q = new LinkedList<>();
            int level = 0;
            HistoryInteger hi = new HistoryInteger(in, "");
            q.add(hi);
            visited[hi.getNum()] = true;
            //bfs start
            while (!q.isEmpty()) {
                int len = q.size();
                for (int i = 0; i < len; i++) {

                    HistoryInteger cur = q.poll();

                    if (cur.getNum() == out) {
                        System.out.println(cur.getOpHistory());
                        q.clear();
                        break;
                    } else {

                        //현재 숫자에서 4가지 연산한 결과들
                        int d = Calculator.d(cur.getNum());
                        int s = Calculator.s(cur.getNum());
                        int l = Calculator.l(cur.getNum());
                        int r = Calculator.r(cur.getNum());

                        //이미 만들어봤던 숫자로 돌아가는 것은 최단이 아님 q에 넣지 않는다.
                        if (!visited[d]) {
                            q.add(new HistoryInteger(d, cur.getOpHistory() + "D"));
                            visited[d] = true;
                        }
                        if (!visited[s]) {
                            q.add(new HistoryInteger(s, cur.getOpHistory() + "S"));
                            visited[s] = true;
                        }
                        if (!visited[l]) {
                            q.add(new HistoryInteger(l, cur.getOpHistory() + "L"));
                            visited[l] = true;
                        }
                        if (!visited[r]) {
                            q.add(new HistoryInteger(r, cur.getOpHistory() + "R"));
                            visited[r] = true;
                        }

                    }
                }
                level++;
            }
        }
    }
}
