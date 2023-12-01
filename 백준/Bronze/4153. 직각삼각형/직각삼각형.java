import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Integer> lines = new ArrayList<>();

            if (a == 0 && b == 0 && c == 0) {
                bw.flush();
                return;
            }

            lines.add(a);
            lines.add(b);
            lines.add(c);

            Collections.sort(lines);
            int max = Math.max(c, Math.max(a, b));
            int cs = lines.get(2) * lines.get(2);
            int as = lines.get(0) * lines.get(0);
            int bs = lines.get(1) * lines.get(1);

            if (cs == as + bs) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }

        }

    }

}

