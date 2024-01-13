import java.util.*;
import java.io.*;

public class Main {

    private static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        visited = new boolean[b + 1];

        int minCount = bfs(a, b);
        bw.write(minCount + "");
        bw.flush();

    }

    /**
     * a를 b로 바꾸어라
     * 가능한 연산은 2를 곱하거나 10을 곱한 뒤 1 더하기
     */
    public static int bfs(int a, int b) {

        Queue<Long> q = new LinkedList<>();
        int level = 0;
        q.add((long) a);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                long cur = q.poll();
                if (cur == b) {
                    return level + 1;
                }
                long next = (long) cur * 2;
                if (next >= 0 && next <= b && !visited[(int) next]) {
                    q.add(next);
                    visited[(int) next] = true;
                }
                next = (cur * 10) + 1;
                if (next >= 0 && next <= b && !visited[(int) next]) {

                    q.add(next);
                    visited[(int) next] = true;
                }
            }
            level++;
        }
        return -1;
    }

}
