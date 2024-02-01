import java.awt.color.ICC_ColorSpace;
import java.util.*;
import java.io.*;

public class Main {
    private static boolean[][] friend;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friend = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            friend[n1][n2] = true;
            friend[n2][n1] = true;
        }

        int minKB = Integer.MAX_VALUE;
        int minId = -1;
        for (int i = 1; i <= N; i++) {
            int kb = calcKB(i);
            if (minKB > kb) {
                minKB = kb;
                minId = i;
            }
        }

        bw.write(String.valueOf(minId));

        bw.flush();
    }

    public static int calcKB(int id) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += calcHop(id, i);
        }
        return sum;
    }
    public static int calcHop(int start, int target) {

        int hop = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == target) {
                    return hop;
                }
                for (int j = 1; j <= N; j++) {
                    if (!visited[j] && friend[cur][j]) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
            hop++;
        }
        return -1;
    }
}