import java.util.*;
import java.io.*;

public class Main {

    private static Integer number = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int year = Integer.parseInt(br.readLine());
        if (isLeapYear(year)) {
            bw.write(1 + "");
        } else {
            bw.write(0 + "");
        }
        bw.flush();
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
}