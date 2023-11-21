import java.util.*;
import java.io.*;

public class Main {

    private static Integer number = 1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            number *= Integer.parseInt(br.readLine());
        }

        char[] chars = number.toString().toCharArray();

        Map<Integer, Integer> numberCountMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            numberCountMap.put(i, 0);
        }

        for (char c : chars) {
            numberCountMap.put(c - 48, numberCountMap.getOrDefault(c - 48, 0) + 1);
        }

        for (int count : numberCountMap.values()) {
            bw.write(count + "");
            bw.newLine();
        }

        bw.flush();
    }

}