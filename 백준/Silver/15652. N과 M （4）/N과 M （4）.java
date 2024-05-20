import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;

    public static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(1, new ArrayList<>(), bw);
    }

    public static void dfs(int idx, List<Integer> arr, BufferedWriter bw) throws IOException {
        if (arr.size() == M) {
            for (int num : arr) {
                bw.write(String.valueOf(num) + " ");
                bw.flush();
            }
            bw.newLine();
            return;
        }

        for (int i = idx; i <= N; i++) {
            arr.add(i);
            dfs(i, arr, bw);
            arr.remove(arr.size() - 1);
        }
    }
}
