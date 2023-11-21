import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        if (input.isBlank()) {
            bw.write("0");
        } else {
            int length = input.trim().split(" ").length;
            bw.write(length + "");
        }
        bw.flush();
    }
}