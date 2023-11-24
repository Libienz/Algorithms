import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        while (num != 0) {
            if (isPalindrome(num)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
            num = Integer.parseInt(br.readLine());
        }

        bw.flush();
    }

    public static boolean isPalindrome(Integer num) {
        int length = num.toString().length();
        for (int i = 0; i < length; i++) {
            if (num.toString().charAt(i) != num.toString().charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
