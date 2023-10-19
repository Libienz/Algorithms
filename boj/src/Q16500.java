import java.util.*;
import java.io.*;

public class Q16500 {

    private static String obj;
    private static int[] dp;
    private static Set<String> words = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        obj = br.readLine();
        dp = new int[obj.length()];

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }


        for (int i = 0; i < obj.length(); i++) {
            for (int j = i + 1; j <= obj.length(); j++) {
                String substring = obj.substring(i, j);
//                System.out.println("substring = " + substring);
//                System.out.println("i = " + i);
//                System.out.println("j = " + j);
                if (words.contains(obj.substring(i, j)) && (i == 0 || dp[i - 1] == 1)) {
                    dp[j - 1] = 1;
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println("dp[" + i + "] = " + dp[i]);
//        }
        bw.write(dp[obj.length() - 1] + "");
        bw.flush();

    }



}
