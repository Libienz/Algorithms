import java.util.*;
import java.io.*;

public class Main {
    private static Long id = 0L;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                numbers.remove(numbers.size() - 1);
            } else {
                numbers.add(number);
            }
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}