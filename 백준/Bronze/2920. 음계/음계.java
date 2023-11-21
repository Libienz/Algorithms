import java.util.*;
import java.io.*;

public class Main {

    private static Integer number = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> scales = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            scales.add(Integer.parseInt(st.nextToken()));
        }
        if (isScalesAscending(scales)) {
            bw.write("ascending");
        } else if (isScalesDescending(scales)) {
            bw.write("descending");
        } else {
            bw.write("mixed");
        }
        bw.flush();
    }

    public static boolean isScalesAscending(List<Integer> scales) {
        int prev = scales.get(0);
        for (int i = 1; i < scales.size(); i++) {
            int cur = scales.get(i);
            if (prev > cur) {
                return false;
            }
            prev = cur;
        }
        return true;
    }

    public static boolean isScalesDescending(List<Integer> scales) {
        int prev = scales.get(0);
        for (int i = 1; i < scales.size(); i++) {
            int cur = scales.get(i);
            if (prev < cur) {
                return false;
            }
            prev = cur;
        }
        return true;
    }

}