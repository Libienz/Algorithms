import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int operationCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < operationCount; i++) {
            String operation = br.readLine();
            executeOperation(operation, bw);
        }
        bw.flush();

    }

    public static void executeOperation(String operation, BufferedWriter bw) throws IOException {
        String[] operationAndArguments = operation.split(" ");
        String op = operationAndArguments[0];

        if (op.equals("add")) {
            int operand = Integer.parseInt(operationAndArguments[1]);
            if (!set.contains(operand)) {
                set.add(operand);
            }
            return;
        }
        if (op.equals("remove")) {
            int operand = Integer.parseInt(operationAndArguments[1]);
            if (set.contains(operand)) {
                set.remove(operand);
            }
            return;
        }
        if (op.equals("check")) {
            int operand = Integer.parseInt(operationAndArguments[1]);
            if (set.contains(operand)) {
                bw.write(String.valueOf(1));
                bw.newLine();
                return;
            }
            if (!set.contains(operand)) {
                bw.write(String.valueOf(0));
                bw.newLine();
                return;
            }
        }
        if (op.equals("toggle")) {
            int operand = Integer.parseInt(operationAndArguments[1]);
            if (set.contains(operand)) {
                set.remove(operand);
                return;
            }
            if (!set.contains(operand)) {
                set.add(operand);
                return;
            }
        }
        if (op.equals("all")) {
            set = createAllContainingSet();
            return;
        }
        if (op.equals("empty")) {
            set = new HashSet<>();
            return;
        }
    }

    public static Set<Integer> createAllContainingSet() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
        return set;
    }
}
