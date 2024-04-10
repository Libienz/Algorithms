import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String Pn = resolvePn(N);

        String S = br.readLine();
        int count = 0;
        for (int i = 0; i <= S.length() - Pn.length(); i++) {
            String substring = S.substring(i, i + Pn.length());
            if (substring.equals(Pn)) {
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
    }

    private static String resolvePn(int N) {
        String result = "";
        for (int i = 0; i < N; i++) {
            result += "OI";
        }
        return "I" + result;
    }
}
