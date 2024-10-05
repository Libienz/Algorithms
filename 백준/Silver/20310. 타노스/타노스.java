import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        int zeroDeleteCount = 0;
        int oneDeleteCount = 0;

        List<Integer> removeIndexes = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (oneDeleteCount == oneCount / 2) {
                break;
            }

            char c = s.charAt(i);
            if (c == '1') {
                removeIndexes.add(i);
                oneDeleteCount++;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (zeroDeleteCount == zeroCount / 2) {
                break;
            }
            char c = s.charAt(i);
            if (c == '0') {
                removeIndexes.add(i);
                zeroDeleteCount++;
            }
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (removeIndexes.contains(i)) {
                continue;
            }
            result += s.charAt(i);
        }

        bw.write(result);
        bw.flush();
    }
}
