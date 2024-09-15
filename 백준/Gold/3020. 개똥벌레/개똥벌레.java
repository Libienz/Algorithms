import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] up;
    private static int[] down;
    private static int n;
    private static int h;
    private static int minConflict = Integer.MAX_VALUE;
    private static int minConflictPathCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        up = new int[n / 2];
        down = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            int downSize = Integer.parseInt(br.readLine());
            int upSize = Integer.parseInt(br.readLine());
            down[i] = downSize;
            up[i] = upSize;
        }

        Arrays.sort(up);
        Arrays.sort(down);

        for (int i = 1; i < h + 1; i++) {
            int countWall = indexOf(0, n / 2, i, down) + indexOf(0, n / 2, h - i + 1, up);

            if (minConflict == countWall) {
                minConflictPathCount++;
                continue;
            }
            if (minConflict > countWall) {
                minConflict = countWall;
                minConflictPathCount = 1;
            }
        }

        bw.write(minConflict + " " + minConflictPathCount);
        bw.flush();
    }

    private static int indexOf(int left, int right, int h, int[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - right;
    }
}
