import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            String markString = br.readLine();
            char[] marks = markString.toCharArray();
            int w = 0;
            int total = 0;
            for (char c : marks) {
                if (c == 'O') {
                    total += w + 1;
                    w++;
                } else {
                    w = 0;
                }
            }

            bw.write(total + "");
            bw.newLine();
        }
        bw.flush();
    }
}