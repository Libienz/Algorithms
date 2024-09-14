import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int r;
    private static int c;
    private static int pedometer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        findPosition(0, 0, size);

        bw.write(String.valueOf(pedometer));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void findPosition(int sr, int sc, int size) {
        if (size == 1) {
            return;
        }

        int halfSize = size / 2;
        int quadrant = 0;

        if (r < sr + halfSize && c < sc + halfSize) {
            quadrant = 0;
        } else if (r < sr + halfSize && c >= sc + halfSize) {
            quadrant = 1;
            c -= halfSize;
        } else if (r >= sr + halfSize && c < sc + halfSize) {
            quadrant = 2;
            r -= halfSize;
        } else {
            quadrant = 3;
            r -= halfSize;
            c -= halfSize;
        }

        pedometer += quadrant * halfSize * halfSize;

        findPosition(sr, sc, halfSize);
    }
}
