import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Spot> spots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            spots.add(new Spot(start, 1));
            spots.add(new Spot(end, -1));
        }

        Collections.sort(spots);

        int maxOverlapCount = Integer.MIN_VALUE;
        int count = 0;
        for (Spot spot : spots) {
            count += spot.weight;
            if (count > maxOverlapCount) {
                maxOverlapCount = count;
            }
        }

        bw.write(String.valueOf(maxOverlapCount));
        bw.flush();
    }

    private static class Spot implements Comparable<Spot> {
        int point;
        int weight;

        public Spot(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }

        @Override
        public int compareTo(Spot o) {
            if (this.point != o.point) {
                return this.point - o.point;
            }
            return this.weight - o.weight;
        }
    }
}
