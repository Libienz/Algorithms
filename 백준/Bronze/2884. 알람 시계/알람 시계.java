import java.util.*;
import java.io.*;

public class Main {

    private static Integer number = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        min -= 45;
        int hw = 0;
        if (min < 0) {
            min = 60 + min;
            hw = -1;
        }
        hour = hour + hw;
        if (hour < 0) {
            hour = 23;
        }

        bw.write(String.format("%d %d", hour, min));
        bw.flush();
    }

}