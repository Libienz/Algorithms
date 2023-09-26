import java.util.*;
import java.io.*;

public class Q20365 {

    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        String cs = br.readLine();
        char[] colors = cs.toCharArray();
        int bc = 0;
        int rc = 0;
        char prev = colors[0];
        if (prev == 'B') {
            bc++;
        } else {
            rc++;
        }
        for (int i = 1; i < colors.length; i++) {
            char c = colors[i];
            if (c == 'B' && prev != 'B') {
                bc++;
            }
            if (c == 'R' && prev != 'R'){
                rc++;
            }
            prev = c;
        }



        if (bc > rc) {
            bw.write(1 + rc + "");
        } else {
            bw.write(1 + bc + "");
        }
        bw.flush();
    }
}
