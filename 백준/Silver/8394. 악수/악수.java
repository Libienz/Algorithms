import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Integer> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new ArrayList<>();

        dp.add(1);
        dp.add(1);
        for (int i = 2; i <= n; i++) {
            int curSize = dp.size();
            Integer prev2 = dp.get(curSize - 2);
            Integer prev1 = dp.get(curSize - 1);
            dp.add((prev2 + prev1) % 10);
        }
        bw.write(String.valueOf(dp.get(n)).charAt(0));
        bw.flush();
    }
}
