import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            nums[i] = number;
        }

        bw.write(calcMin(nums) + " ");
        bw.write(calcMax(nums) + "");
        bw.flush();

    }

    public static int calcMax(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int cur : numbers) {
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

    public static int calcMin(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int cur : numbers) {
            if (cur < min) {
                min = cur;
            }
        }
        return min;
    }
}