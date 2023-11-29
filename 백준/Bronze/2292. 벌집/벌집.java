import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int level = 1;

        while (start > N || end < N) {
            start = end + 1;
            end = start + (6 * level) - 1;
            level++;
        }

        bw.write(String.valueOf(level));
        bw.flush();
    }
}