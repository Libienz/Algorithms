import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
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
        int prev = -1;
        for (int i = idx; i < N; i++) {
            int cur = numbers[i];
            if (cur == prev) {
                continue;
            }
            choiced.add(cur);
            dfs(i, choiced);
            choiced.remove(choiced.size() - 1);
            prev = cur;
        }
    }
}

