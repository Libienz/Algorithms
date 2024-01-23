import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Integer> nums = new ArrayList<>();
    private static ArrayList<Character> ops = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String exp = br.readLine();
        char[] cs = exp.toCharArray();

        marshallNumsAndOps(cs);
        bw.write(calculate() + "");
        bw.flush();

    }

    private static void marshallNumsAndOps(char[] cs) {
        //marshalling
        int num = 0;
        for (char c : cs) {
            if (c == '-' || c == '+') {
                ops.add(c);
                num = num / 10;

                nums.add(num);
                num = 0;
                continue;
            }
            num += c - 48;
            num *= 10;

        }

        nums.add(num / 10);
    }

    public static int calculate() {

        int res = 0;
        ArrayList<Integer> substractIndexes = new ArrayList<>();
        for (int i = 0; i < ops.size(); i++) {
            int operand1 = nums.get(i);
            int operand2 = nums.get(i + 1);
            if (ops.get(i) == '-') {
                substractIndexes.add(i);
            }
        }

        int w = 0;
        for (int i = 0; i < substractIndexes.size(); i++) {
            Integer si = substractIndexes.get(i);
            //다음 빼기가 나오기 전까지 괄호 묶기

            //빼기가 더 이상 없다면

            if (substractIndexes.size() == i + 1) {

                for (int j = si + 1; j < nums.size(); j++) {
                    w += nums.get(j);
                }
            }
            //뒤에 빼기가 있다면 빼기 전까지 괄호 묶기
            else {
                for (int j = si + 1; j <= substractIndexes.get(i + 1); j++) {
                    w += nums.get(j);
                }
            }
        }
        int total = 0;

        for (int i = 0; i < nums.size(); i++) {
            total += nums.get(i);
        }

        return total - (2 * w);
    }
}
