import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                int cur = Integer.parseInt(row.charAt(j)+"");
                map[i][j] = cur;
            }
        }

        Node sn = new Node(0, 0);
        visited[0][0] = true;
        int res = countHop(sn);
        bw.write(res + 1 + "");
        bw.newLine();
        bw.flush();

    }

    public static int countHop(Node sn) {

        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(sn);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();

                if (cur.r == N - 1 && cur.c == M - 1) {
                    return level;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + moveR[j];
                    int nc = cur.c + moveC[j];
                    //index out or visited or blocked
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visited[nr][nc]) {
                        continue;
                    }
                    q.offer(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
            level++;
        }
        return -1;
    }
    static class Node {
        private int r;
        private int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
