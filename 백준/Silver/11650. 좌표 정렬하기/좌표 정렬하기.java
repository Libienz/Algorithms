import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Point point = new Point(x, y);

            points.add(point);
        }

        Collections.sort(points);

        for (Point p : points) {
            bw.write(String.valueOf(p.x) + " ");
            bw.write(String.valueOf(p.y) + "\n");
        }
        bw.flush();
    }

    static class Point implements Comparable<Point> {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (o.x == this.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}