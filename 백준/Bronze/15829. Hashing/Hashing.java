import java.util.*;
import java.io.*;

public class Main {

    private static final int R = 31;
    private static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(String.valueOf(calcHash(str)));
        bw.flush();
    }

    public static long calcHash(String str) {
        char[] cs = str.toCharArray();
        List<Integer> arr = new ArrayList<>();
        for (char c : cs) {
            arr.add(c - 96);
        }

        long hash = 0;
        for (int i = 0; i < arr.size(); i++) {
            hash += (long) (arr.get(i) * Math.pow(R, i));
        }
        return hash % M;
    }
}