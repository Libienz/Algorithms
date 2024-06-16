import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int N;
    private static List<Integer> numbers = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        dfs(0, new ArrayList<>(), bw);
    }

    public static void dfs(int cur, List<Integer> choiced, BufferedWriter bw) throws IOException {

        if (choiced.size() == N) {
            for (int num : choiced) {
                bw.write(num + " ");
            }
            bw.newLine();
            bw.flush();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            choiced.add(numbers.get(i));
            dfs(cur + 1, choiced, bw);
            visited[i] = false;
            choiced.remove(choiced.size() - 1);
        }
    }
}
