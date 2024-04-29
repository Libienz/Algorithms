import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static Map<Integer, Integer> move = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M + N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            move.put(start, destination);
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    public static int bfs() {
        int start = 1;
        if (move.containsKey(1)) {
            start = move.get(1);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.add(start);
        visited[start] = true;
        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer cur = q.poll();
                if (cur == 100) {
                    return level;
                }
                for (int j = 1; j <= 6; j++) {
                    int next = cur + j;
                    if (move.containsKey(next)) {
                        visited[next] = true;
                        next = move.get(next);
                    }

                    if (next > 100) {
                        continue;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
