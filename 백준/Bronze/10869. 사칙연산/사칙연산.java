import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int op1 = Integer.parseInt(st.nextToken());
        int op2 = Integer.parseInt(st.nextToken());

        bw.write(op1 + op2 + "\n");
        bw.write(op1 - op2 + "\n");
        bw.write(op1 * op2 + "\n");
        bw.write(op1 / op2 + "\n");
        bw.write(op1 % op2 + "\n");

        bw.flush();
    }

}