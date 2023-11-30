import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(calcGcd(num1, num2)) + "\n");
        bw.write(String.valueOf(calcLcm(num1, num2)) + "\n");
        bw.flush();
    }

    public static int calcGcd(int num1, int num2) {
        int smallerNumber = Math.min(num1, num2);
        int gcd = 1;
        for (int i = 2; i <= smallerNumber; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int calcLcm(int num1, int num2) {
        int mNum1 = num1;
        int w1 = 2;
        int mNum2 = num2;
        int w2 = 2;
        while (mNum1 != mNum2) {
            if (mNum1 < mNum2) {
                mNum1 = num1 * w1++;
            } else {
                mNum2 = num2 * w2++;
            }
        }

        return mNum2;

    }
}

