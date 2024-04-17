import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static Map<String, List<String>> closet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            closet = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                if (!closet.containsKey(type)) {
                    List<String> clothList = new ArrayList<>();
                    clothList.add(name);
                    closet.put(type, clothList);
                } else {
                    List<String> clothList = closet.get(type);
                    clothList.add(name);
                }
            }
            int total = 0;
            for (String type : closet.keySet()) {
                int count = closet.get(type).size();
                if (total == 0) {
                    total += (count + 1);
                } else {
                    total *= (count + 1);
                }

            }

            if (total == 0) {
                bw.write(String.valueOf(0));
            } else {
                bw.write(String.valueOf(total - 1));
            }
            bw.newLine();
        }

        bw.flush();
    }
}
