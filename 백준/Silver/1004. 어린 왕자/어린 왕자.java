import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            List<Circle> circles = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                circles.add(new Circle(cx, cy, r));
            }

            int res = 0;
            for (Circle circle : circles) {
                boolean startInCircle = false;
                boolean destInCircle = false;

                if (circle.isPointInCircle(sx, sy)) {
                    startInCircle = true;
                    res++;
                }
                if (circle.isPointInCircle(dx, dy)) {
                    destInCircle = true;
                    res++;
                }

                if (startInCircle && destInCircle) {
                    res -= 2;
                }
            }
            bw.write(String.valueOf(res));
            bw.newLine();
            bw.flush();
        }
    }

    private static class Circle {
        int x;
        int y;
        int r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public boolean isPointInCircle(int tx, int ty) {
            int xDist = Math.abs(tx - x);
            int yDist = Math.abs(ty - y);
            return Math.pow(r, 2) >= (Math.pow(xDist, 2) + Math.pow(yDist, 2));
        }
    }
}
