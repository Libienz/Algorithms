import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int score = Integer.parseInt(br.readLine());

        if (score >= 90 && score <= 100) {
            bw.write("A");
        }
        if (score >= 80 && score <= 89) {
            bw.write("B");
        }
        if (score >= 70 && score <= 79) {
            bw.write("C");
        }
        if (score >= 60 && score <= 69) {
            bw.write("D");
        }
        if (score >= 0 && score <= 59) {
            bw.write("F");
        }
        bw.flush();
    }
}