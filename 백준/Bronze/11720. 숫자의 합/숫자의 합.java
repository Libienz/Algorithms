import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String numString = br.readLine();

        int res = 0;
        for (int i = 0; i < N; i++) {
            char cur = numString.charAt(i);
            res += cur - 48;
        }

        bw.write(res + "");
        bw.flush();
        
    }
}