import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int K;
    private static Integer[] cvs;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cvs = new Integer[N];
        visited = new boolean[K+1];
        for (int i = 0; i < N; i++) {
            cvs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cvs, Comparator.reverseOrder());
        int res = 0;
        for (Integer cv : cvs) {
            if (K == 0) {
                break;
            }
            if (cv <= K) {
                res += K / cv;
                K = K % cv;
//                System.out.println("K = " + K);
            }
        }

        bw.write(res + "");
        bw.flush();

    }

    public static int countCoins() {

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int level = 0;
        visited[0] = true;

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer cur = q.poll();
                if (cur == K) {
                    return level;
                }
                for (int cv : cvs) {
                    Integer next = cur + cv;
                    if (next <= K && !visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            level++;
        }
        return -1;

    }
}
