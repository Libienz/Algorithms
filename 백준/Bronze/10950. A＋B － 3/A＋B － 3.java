import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int operand1 = Integer.parseInt(st.nextToken());
            int operand2 = Integer.parseInt(st.nextToken());

            bw.write(operand1 + operand2 + "\n");
        }

        bw.flush();
    }
}
