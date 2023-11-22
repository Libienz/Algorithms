import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        char[] chars = S.toCharArray();

        for (int i = 97; i <= 122; i++) {
            char c = (char) i;
            bw.write(findCharIndex(chars, c) + " ");
        }
        bw.flush();
    }

    public static int findCharIndex(char[] chars, char obj) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == obj) {
                return i;
            }
        }
        return -1;
    }
}