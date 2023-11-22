import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); //층수
            int W = Integer.parseInt(st.nextToken()); //각 층의 방의 개수
            int N = Integer.parseInt(st.nextToken());

            int count = 0;
            int floor = 0;
            int room = 0;
            for (int j = 1; j <= W; j++) {
                for (int k = 1; k <= H; k++) {
                    count++;
                    if (count == N) {
                        floor = k;
                        room = j;
                        bw.write(floor + "");
                        bw.write(String.format("%02d", room));
                        bw.newLine();
                        break;
                    }
                }
            }
        }
        bw.flush();
    }
}