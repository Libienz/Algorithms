import java.util.*;
import java.io.*;

public class Q1343 {

    private static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        char[] ca = str.toCharArray();
        visited = new boolean[ca.length];
        for (int i = 0; i < ca.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            char cur = ca[i];

            if (cur == 'X') {
                //x등장 폴리오미노로 덮어야 함

                //4개로 덮을 수 있다면 덮는다
                boolean ableWithApolio = true;

                for (int j = 0; j < 4; j++) {
                    if (i + j >= ca.length) {
                        ableWithApolio = false;
                        break;
                    }
                    if (ca[i + j] != 'X') {
                        ableWithApolio = false;
                        break;
                    }
                }
                if (ableWithApolio) {
                    ca[i] = 'A';
                    ca[i + 1] = 'A';
                    ca[i + 2] = 'A';
                    ca[i + 3] = 'A';
                    visited[i] = true;
                    visited[i + 1] = true;
                    visited[i + 2] = true;
                    visited[i + 3] = true;
                    continue;
                }
                //2개로 덮을 수 있다면 덮는다.

                //4개로 덮을 수 있다면 덮는다
                boolean ableWithBpolio = true;

                for (int j = 0; j < 2; j++) {
                    if (i + j >= ca.length) {
                        ableWithBpolio = false;
                        break;
                    }
                    if (ca[i + j] != 'X') {
                        ableWithBpolio = false;
                        break;

                    }
                }
                if (ableWithBpolio) {
                    ca[i] = 'B';
                    ca[i + 1] = 'B';
                    visited[i] = true;
                    visited[i + 1] = true;
                    continue;
                }
                //덮지 못하는 상황이다.
                bw.write(-1 + "");
                bw.flush();
                return;
            }
        }

        for (int i = 0; i < ca.length; i++) {
            bw.write(ca[i]+"");
        }
        bw.flush();
        return;
    }
}
