import java.util.*;
import java.io.*;

public class Main {

    private static final int targetNumber = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(bfs(N)));
        bw.flush();
    }

    public static int bfs(int number) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[number + 1];
        int operationCount = 0;

        q.add(number);
        visited[number] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == targetNumber) {
                    return operationCount;
                }
                int result = operation1(cur);
                if (!visited[result]) {
                    q.add(result);
                    visited[result] = true;
                }
                result = operation2(cur);
                if (!visited[result]) {
                    q.add(result);
                    visited[result] = true;
                }
                result = operation3(cur);
                if (!visited[result]) {
                    q.add(result);
                    visited[result] = true;
                }
            }

            operationCount++;
        }
        return -1;
    }

    public static int operation1(int number) {
        if (number % 3 == 0 || number < 1) {
            return number / 3;
        }
        return number;
    }

    public static int operation2(int number) {
        if (number % 2 == 0 || number < 1) {
            return number / 2;
        }
        return number;
    }

    public static int operation3(int number) {
        if (number < 1) {
            return number;
        }
        return number - 1;
    }
}