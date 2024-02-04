import java.io.*;
import java.util.*;

public class Main {
    private static final int MIN = 0;
    private static final int MAX = 100000;
    private static boolean[] visited = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int res = countHop(start, target);
        bw.write(String.valueOf(res));
        bw.flush();
    }

    public static int countHop(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        int hop = 0;
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer cur = q.poll();

                if (cur == target) {
                    return hop;
                }

                int next = cur * 2;
                if (validateNextLocation(next)) {
                    q.add(next);
                }
                next = cur - 1;
                if (validateNextLocation(next)) {
                    q.add(next);
                }
                next = cur + 1;
                if (validateNextLocation(next)) {
                    q.add(next);
                }
            }
            hop++;
        }
        return -1;
    }

    private static boolean validateNextLocation(int next) {
        if (next >= MIN && next <= MAX && !visited[next]) {
            visited[next] = true;
            return true;
        }
        return false;
    }
}