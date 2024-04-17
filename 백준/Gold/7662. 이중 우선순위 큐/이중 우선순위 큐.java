import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int operationCount = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for (int j = 0; j < operationCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int operand = Integer.parseInt(st.nextToken());

                if (operation.equals("I")) {
                    tm.put(operand, tm.getOrDefault(operand, 0) + 1);
                    continue;
                }
                if (operation.equals("D")) {
                    if (tm.isEmpty()) {
                        continue;
                    }
                    if (operand == 1) {
                        Integer max = tm.lastKey();
                        if (tm.get(max) == 1) {
                            tm.remove(max);
                            continue;
                        }
                        if (tm.get(max) > 1) {
                            tm.put(max, tm.get(max) - 1);
                        }
                    }
                    if (operand == -1) {
                        Integer min = tm.firstKey();
                        if (tm.get(min) > 1) {
                            tm.put(min, tm.get(min) - 1);
                            continue;
                        }
                        if (tm.get(min) == 1) {
                            tm.remove(min);
                            continue;
                        }
                    }
                }
            }
            if (tm.isEmpty()) {
                bw.write("EMPTY");
                bw.newLine();
                continue;
            }
            bw.write(String.valueOf(tm.lastKey()));
            bw.write(" ");
            bw.write(String.valueOf(tm.firstKey()));
            bw.newLine();
        }
        bw.flush();
    }
}
