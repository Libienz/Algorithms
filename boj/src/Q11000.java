import java.util.*;
import java.io.*;

public class Q11000 {

    private static ArrayList<Lecture> lectures;
    private static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        lectures = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(s, f));
        }

        Collections.sort(lectures);
        int prev = 0;
        pq.add(lectures.get(0).finishTime);
        for (int i = 1; i < lectures.size(); i++) {
            Lecture cur = lectures.get(i);
            Integer peek = pq.peek();
//            System.out.println("peek = " + peek);
            if (cur.startTime >= peek) {
                //can concat
                pq.poll();
                pq.add(cur.finishTime);
            } else {
                //cannot concat
                pq.add(cur.finishTime);
            }

        }

        bw.write(pq.size() + "");
        bw.flush();
    }

    static class Lecture implements Comparable<Lecture> {

        private int startTime;
        private int finishTime;

        public Lecture(int startTime, int finishTime) {
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        @Override
        public int compareTo(Lecture o) {
            return startTime - o.startTime;
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "startTime=" + startTime +
                    ", finishTime=" + finishTime +
                    '}';
        }
    }
}
