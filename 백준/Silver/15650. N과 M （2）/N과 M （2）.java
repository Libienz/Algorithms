import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(1, new ArrayList<>(), bw);
        bw.flush();
    }

    public static void dfs(int idx, List<Integer> choices, BufferedWriter bw) throws IOException {
        if (choices.size() == M) {
            for (int num : choices) {
                bw.write(String.valueOf(num) + " ");
            }
            bw.newLine();
            return;
        }

        if (idx > N) {
            return;
        }
        choices.add(idx);
        dfs(idx + 1, choices, bw);
        choices.remove(choices.size() - 1);
        dfs(idx + 1, choices, bw);
    }
}
