import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> unheard = new HashSet<>();
        HashSet<String> unSaw = new HashSet<>();
        List <String> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            unSaw.add(br.readLine());
        }

        for (String p : unSaw) {
            if (unheard.contains(p)) {
                res.add(p);
            }
        }

        Collections.sort(res);

        bw.write(String.valueOf(res.size()));
        bw.newLine();

        for (String p : res) {
            bw.write(p);
            bw.newLine();
        }

        bw.flush();
    }
}