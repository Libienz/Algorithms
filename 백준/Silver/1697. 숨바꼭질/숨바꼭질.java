import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tagger = Integer.parseInt(st.nextToken());
        int hider = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(countSecondsForHideAndSeek(tagger, hider)));
        bw.flush();
    }

    public static int countSecondsForHideAndSeek(int taggerPosition, int hiderPosition) {
        Queue<Integer> q = new LinkedList<>();
        int seconds = 0;
        boolean[] visited = new boolean[100001];
        q.add(taggerPosition);
        visited[taggerPosition] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Integer cur = q.poll();
                if (cur == hiderPosition) {
                    return seconds;
                }

                int np = cur + 1;
                if (np >= 0 && np <= 100000 && !visited[np]) {
                    q.add(np);
                    visited[np] = true;
                }
                np = cur - 1;
                if (np >= 0 && np <= 100000 && !visited[np]) {
                    q.add(np);
                    visited[np] = true;
                }
                np = cur * 2;
                if (np >= 0 && np <= 100000 && !visited[np]) {
                    q.add(np);
                    visited[np] = true;
                }
            }
            seconds++;
        }
        return -1;
    }
}
