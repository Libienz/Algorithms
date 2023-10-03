import java.io.*;

public class Q21314 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String mk = br.readLine();
        char[] cs = mk.toCharArray();

        bw.write(getMax(mk) + "");
        bw.newLine();
        bw.write(getMin(mk) + "");
        bw.flush();

    }

    public static String getMax(String mk) {

        int si = 0;
        String res = "";
        for (int i = 0; i < mk.length(); i++) {
            char cur = mk.charAt(i);
            if (cur == 'K') {
                String subStr = mk.substring(si, i+1);
                String convert = convert(subStr);
                res += convert;
                si = i + 1;
            }
        }
        if (si != mk.length()) {

            String subStr = mk.substring(si, mk.length());
            for (int i = 0; i < subStr.length(); i++) {
                res += 1;
            }
//            res += convert(subStr);
        }
        return res;
    }

    public static String getMin(String mk) {
        int si = 0;
        String res = "";
        for (int i = 0; i < mk.length(); i++) {
            char cur = mk.charAt(i);
            if (cur == 'K') {
                if (si < i) {
                    String subStr = mk.substring(si, i);
                    String convert = convert(subStr);
                    res += convert;
                }
                si = i + 1;
                res += 5;
            }
        }
        if (si != mk.length()) {

            String subStr = mk.substring(si, mk.length());
            res += convert(subStr);
        }
        return res;
    }

    public static String convert(String mk) {

        String res = "";
        if (mk.charAt(mk.length() - 1) == 'K') {
            res += 5;
            for (int i = 0; i < mk.length() - 1; i++) {
                res += 0;
            }
//            return 5 * (int) Math.pow(10, mk.length() - 1);
        } else {
            res += 1;
            for (int i = 0; i < mk.length() - 1; i++) {
                res += 0;
            }
//            return 1 * (int) Math.pow(10, mk.length() - 1);
        }

        return res;
    }
}
