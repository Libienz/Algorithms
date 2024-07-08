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

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(countHop(A, K)));
        bw.flush();
    }

    public static int countHop(int a, int k) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[k + 1];
        int level = 0;
        q.add(a);
        visited[a] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Integer cur = q.poll();
                if (cur == k) {
                    return level;
                }
                int operationResult = operation1(cur);

                if (operationResult <= k && !visited[operationResult]) {
                    q.add(operationResult);
                    visited[operationResult] = true;
                }

                operationResult = operation2(cur);
                if (operationResult <= k && !visited[operationResult]) {
                    q.add(operationResult);
                    visited[operationResult] = true;
                }
            }
            level++;
        }
        return -1;

    }

    public static int operation1(int number) {
        return number + 1;
    }

    public static int operation2(int number) {
        return number * 2;
    }
}
