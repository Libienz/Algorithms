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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);
        dfs(0, new ArrayList<>());
    }

    public static void dfs(int idx, List<Integer> choiced) {

        if (choiced.size() == M) {
            for (int num : choiced) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = idx; i < N; i++) {
            choiced.add(numbers.get(i));
            dfs(i, choiced);
            choiced.remove(choiced.size() - 1);
        }
    }
}

