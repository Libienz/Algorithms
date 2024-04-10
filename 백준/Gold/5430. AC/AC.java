import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static int popFirst = 0;
    private static int popRear = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            popFirst = 0;
            popRear = 0;
            List<String> functions = parseFunctions(br.readLine());
            int n = Integer.parseInt(br.readLine());
            if (countPopFunction(functions) > n) {
                br.readLine();
                bw.write("error");
                bw.newLine();
                continue;
            }
            List<Integer> numbers = parseNumbers(br.readLine());
            setPopInstructions(functions);
            applyPop(numbers);
            if (reverse(functions)) {
                Collections.reverse(numbers);
            }
            bw.write(toAnswer(numbers));
            bw.newLine();
        }
        bw.flush();
    }

    private static List<String> parseFunctions(String functions) {
        List<String> functionList = new ArrayList<>();
        for (int i = 0; i < functions.length(); i++) {
            functionList.add(functions.charAt(i) + "");
        }
        return functionList;
    }

    private static List<Integer> parseNumbers(String numberString) {
        String substring = numberString.substring(1, numberString.length() - 1);
        List<Integer> res = new ArrayList<>();

        if (substring.isEmpty()) {
            return res;
        }
        for (String s : substring.split(",")) {
            res.add(Integer.parseInt(s));
        }
        return res;
    }

    private static boolean reverse(List<String> functions) {
        int reverseCount = 0;
        for (String f : functions) {
            if (f.equals("R")) {
                reverseCount++;
            }
        }
        if (reverseCount % 2 == 0) {
            return false;
        }
        return true;
    }

    private static int countPopFunction(List<String> functions) {
        int count = 0;
        for (String f : functions) {
            if (f.equals("D")) {
                count++;
            }
        }
        return count;
    }

    private static void setPopInstructions(List<String> functions) {
        boolean popFront = true;
        for (String f : functions) {
            if (f.equals("R")) {
                if (popFront) {
                    popFront = false;
                } else {
                    popFront = true;
                }
            }
            if (f.equals("D")) {
                if (popFront) {
                    popFirst++;
                } else {
                    popRear++;
                }
            }
        }
    }

    private static void applyPop(List<Integer> numbers) {
        while (popFirst > 0) {
            numbers.remove(0);
            popFirst--;
        }
        while (popRear > 0) {
            numbers.remove(numbers.size() - 1);
            popRear--;
        }
    }

    private static String toAnswer(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")) + "]";
    }
}
