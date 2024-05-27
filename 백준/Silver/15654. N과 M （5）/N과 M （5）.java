import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;

    private static List<Integer> numbers = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        Collections.sort(numbers);
        dfs(new ArrayList<>(), bw);
        bw.flush();

    }

    public static void dfs(List<Integer> choices, BufferedWriter bw) throws IOException {
        if (choices.size() == M) {
            for (int num : choices) {
                bw.write(String.valueOf(num) + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == true) {
                continue;
            }

            visited[i] = true;
            choices.add(numbers.get(i));

            dfs(choices, bw);

            visited[i] = false;
            choices.remove(choices.size() - 1);
        }

    }
}
