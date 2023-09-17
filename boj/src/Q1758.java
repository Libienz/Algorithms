import java.util.*;
import java.io.*;

public class Q1758 {

    private static int N;
    private static List<Integer> tips = new ArrayList<>();
    private static Long totalTip = 0L;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int tip = Integer.parseInt(br.readLine());
            tips.add(tip);
        }
        Collections.sort(tips, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            Integer tip = tips.get(i);
            tip = tip - i;
            if (tip < 0) {
                continue;
            }
            totalTip += tip;
        }

        bw.write(totalTip + "");
        bw.flush();

    }
}
