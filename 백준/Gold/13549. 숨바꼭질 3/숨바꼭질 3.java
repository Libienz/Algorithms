import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] MOVE_WEIGHT = {-1, 1};
    private static int minSecond = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(countSecondsForHideAndSeek(N, K)));

        bw.flush();
    }

    public static int countSecondsForHideAndSeek(int taggerPosition, int hiderPosition) {
        Queue<Position> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.add(new Position(taggerPosition, 0));
        visited[taggerPosition] = true;
        int minSeconds = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Position cur = q.poll();
            visited[cur.position] = true;
            if (cur.position == hiderPosition) {
                minSeconds = Math.min(minSeconds, cur.second);
            }
            int next = cur.position * 2;
            if (next >= 0 && next <= 100000 && !visited[next]) {
                q.add(new Position(next, cur.second));
            }
            next = cur.position + 1;
            if (next >= 0 && next <= 100000 && !visited[next]) {
                q.add(new Position(next, cur.second + 1));
            }
            next = cur.position - 1;
            if (next >= 0 && next <= 100000 && !visited[next]) {
                q.add(new Position(next, cur.second + 1));
            }
        }
        return minSeconds;
    }


    private static class Position {
        int position;
        int second;

        public Position(int position, int second) {
            this.position = position;
            this.second = second;
        }
    }
}
