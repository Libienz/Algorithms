import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] maze;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        maze = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(countHop()));
        bw.flush();
    }

    public static int countHop() {
        Queue<Integer> q = new LinkedList<>();
        int hop = 0;
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();
                if (cur == n - 1) {
                    return hop;
                }

                for (int j = 1; j <= maze[cur]; j++) {
                    if (cur + j < n && !visited[cur + j]) {
                        visited[cur + j] = true;
                        q.add(cur + j);
                    }
                }
            }

            hop++;
        }
        return -1;
    }
}
