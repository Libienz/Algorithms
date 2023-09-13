import java.util.*;
import java.io.*;

public class Q2828 {

    private static int N;
    private static int M;
    private static int J;
    private static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(br.readLine());

        int basketLeft = 1;
        int basketRight = 1 + M - 1;
        for (int i = 0; i < J; i++) {
            int dropPosition = Integer.parseInt(br.readLine());

            if (dropPosition < basketLeft) {
                while (basketLeft != dropPosition) {
                    basketLeft--;
                    basketRight--;
                    res++;
                }
            } else if (dropPosition > basketRight) {
                while (basketRight != dropPosition) {
                    basketLeft++;
                    basketRight++;
                    res++;
                }
            }
        }

        bw.write(res + "");
        bw.flush();

    }
}
