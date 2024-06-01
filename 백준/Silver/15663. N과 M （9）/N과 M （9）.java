import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static List<Integer> numbers = new ArrayList<>();
    private static List<List<Integer>> choices = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);
        dfs(new ArrayList<>());
    }

    public static void dfs(List<Integer> choiced) {

        if (choiced.size() == M) {
            for (int num : choiced) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int prev = 0;
        for (int i = 0; i < numbers.size(); i++) {
            Integer cur = numbers.get(i);
            if (visited[i]) {
                continue;
            }

            if (prev == cur) {
                continue;
            }
            choiced.add(cur);
            visited[i] = true;
            prev = cur;
            dfs(choiced);
            choiced.remove(choiced.size() - 1);
            visited[i] = false;
        }
    }
}

