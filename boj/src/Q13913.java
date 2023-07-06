import java.util.*;


public class Q13913 {
    static int n; //수빈이의 위치
    static int k; //동생의 위치
    static int[] parent;


    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        parent[n] = -2; //출발 지점 방문했다고 등록 그리고 -2로 구별
        int level = 0;
        q.add(n);

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {
                int curP = q.poll(); //수빈이의 위치
                if (curP == k) {

                    System.out.println(level);
                    return;
                }
                int nextP;
                //수빈이는 1초 후에 X-1, X+1, X*2로 갈 수 있다
                nextP = curP * 2;
                if (nextP >= 0 && nextP <= 100000 && parent[nextP] == -1) {
//                    visited[nextP] = true;
                    parent[nextP] = curP;
                    q.offer(nextP);
                }
                nextP = curP - 1;
                if (nextP >= 0 && nextP <= 100000 && parent[nextP] == -1) {
//                    visited[nextP] = true;
                    parent[nextP] = curP;
                    q.offer(nextP);
                }
                nextP = curP + 1;
                if (nextP >= 0 && nextP <= 100000 && parent[nextP] == -1) {
//                    visited[nextP] = true;
                    parent[nextP] = curP;
                    q.offer(nextP);

                }

            }
            level++;
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //수빈이의 위치
        k = sc.nextInt(); //동생의 위치

//        visited = new boolean[100001];
        parent = new int[100001];
        for (int i = 0; i < parent.length; i++) {
//            visited[i] = false;
            parent[i] = -1;
        }

        bfs();
        Stack<Integer> st = new Stack<>();

        String route = "";
        int pos = parent[k];
        while (pos != -2) {
            st.push(pos);
            pos = parent[pos];
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println(k);


    }

}
