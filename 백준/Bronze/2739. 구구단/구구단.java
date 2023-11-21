import java.util.*;
import java.io.*;

public class Main {

    private static Integer number = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 9; i++) {
            bw.write(number + " * " + i + " = " + number * i);
            bw.newLine();
        }
        bw.flush();
    }
}