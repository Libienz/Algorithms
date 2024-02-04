import java.io.*;
import java.util.*;

public class Main {

    private static HashMap<Integer, String> encyclopediaIntegerToString = new HashMap<>();
    private static HashMap<String, Integer> encyclopediaStringToInteger = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            encyclopediaIntegerToString.put(i, name);
            encyclopediaStringToInteger.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            if (isNumeric(problem)) {
                bw.write(encyclopediaIntegerToString.get(Integer.parseInt(problem)));
                bw.newLine();
            } else {
                bw.write(String.valueOf(encyclopediaStringToInteger.get(problem)));
                bw.newLine();
            }
        }

        bw.flush();
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}