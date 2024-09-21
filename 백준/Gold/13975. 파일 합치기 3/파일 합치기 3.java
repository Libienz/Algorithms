import java.util.*;
import java.io.*;

public class Main {

    private static List<PriorityQueue<Long>> tests = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            Long K = Long.parseLong(br.readLine()); //chapter size
            PriorityQueue<Long> sizes = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                sizes.add(Long.parseLong(st.nextToken()));
            }
            tests.add(sizes);
        }

        for (PriorityQueue<Long> test : tests) {
            Long res = calcCost(test);
            bw.write(res + "");
            bw.newLine();
        }
        bw.flush();
    }

    public static Long calcCost(PriorityQueue<Long> sizes) {
        Long res = 0L;
        while (sizes.size() != 1) {
            Long c1 = sizes.poll();
            Long c2 = sizes.poll();
            sizes.add(c1 + c2);
            res += (c1 + c2);
        }
        return res;
    }
}
