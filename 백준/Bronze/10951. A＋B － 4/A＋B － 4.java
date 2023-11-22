import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = br.readLine()) != null) {
//            System.out.println("input = " + input);
            StringTokenizer st = new StringTokenizer(input);
            int operand1 = Integer.parseInt(st.nextToken());
            int operand2 = Integer.parseInt(st.nextToken());
            bw.write(operand1 + operand2 + "\n");
        }
        bw.flush();
    }
}