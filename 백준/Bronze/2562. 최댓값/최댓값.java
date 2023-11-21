import java.util.*;
import java.io.*;

public class Main {

    private static int maxNumber = Integer.MIN_VALUE;
    private static int maxNumberIdx = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            nums.add(num);
            if (num > maxNumber) {
                maxNumber = num;
                maxNumberIdx = i;
            }
        }

        bw.write(maxNumber + "");
        bw.newLine();
        bw.write(maxNumberIdx + 1 + "");
        bw.flush();
    }

}