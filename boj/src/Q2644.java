import java.util.*;
import java.io.*;

public class Q2644 {

    private static int n;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken()) - 1;
        int p2 = Integer.parseInt(st.nextToken()) - 1;
        int m = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[p][c] = 1;
            map[c][p] = 1;
        }

        int res = countHop(p1, p2);
        bw.write(res +"\n");
        bw.flush();
    }

    //bfs p1, p2의 촌수 계산기
    public static int countHop(int p1, int p2) {

        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(p1);
        visited[p1][p1] = true;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer cur = q.poll();
                if (cur == p2) {
                    return level;
                }
                for (int j = 0; j < n; j++) {
                    if (map[cur][j] == 1 && !visited[cur][j]) {
                        q.add(j);
                        visited[cur][j] = true;
                    }
                }
            }
            level++;
        }
        return -1;

    }
}
