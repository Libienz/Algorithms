import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        List<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            arr.add(q.poll());
        }

        StringBuilder stbd = new StringBuilder();
        stbd.append("<");
        for (int i = 0; i < arr.size(); i++) {
            stbd.append(String.valueOf(String.valueOf(arr.get(i))));
            if (i < arr.size() - 1) {
                stbd.append(", ");
            }
        }
        stbd.append(">");
        
        bw.write(stbd.toString());
        bw.flush();
    }

}