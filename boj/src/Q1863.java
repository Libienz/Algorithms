import java.util.*;
import java.io.*;

public class Q1863 {

    private static int n;
    private static List<Integer> heights = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            heights.add(y);
        }

        int res = 0;
        int prev = 0;
        heights.add(0);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < heights.size(); i++) {
            Integer cur = heights.get(i);
            //새로운 건물의 시작임을 알 수 있다.
            if (prev < cur && !pq.contains(cur)) {
                pq.add(cur);
            }
            //하나의 건물로 칠 수 있다.
            else if (cur == prev) {

            }
            //앞의 건물을 확정할 수 있다.
            else {
                while (!pq.isEmpty() && pq.peek() > cur) {
                    Integer poll = pq.poll();

                    res++;
                }
                if (!pq.contains(cur)) {

                    pq.add(cur);
                }
            }
            prev = cur;
        }
        bw.write(res + "");
        bw.flush();
    }
}
