import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = pow(A, B, C);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    //calc (A^B) % C
    // 원칙 : (a * b) mod c = (a mod c *  b mod c) mod c
    public static long pow(int A, int exponent, int C) {

        if (exponent == 1) {
            return A % C;
        }

        long temp = pow(A, exponent / 2, C);

        if (exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;
    }
}
