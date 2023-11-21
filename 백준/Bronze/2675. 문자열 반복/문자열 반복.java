import java.util.*;
import java.io.*;

public class Main {

    private static Integer number = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rn = Integer.parseInt(st.nextToken());
            String rs = st.nextToken();

            for (char c : rs.toCharArray()) {
                for (int j = 0; j < rn; j++) {
                    bw.write(c + "");
                }
            }
            bw.newLine();
        }
        bw.flush();
    }

}