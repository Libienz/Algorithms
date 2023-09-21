import java.util.*;
import java.io.*;

public class Q19598 {

    private static int N;
    private static ArrayList<Meeting> meetings = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(s, f));
        }

        //회의 시작 시간 순으로 정렬
        Collections.sort(meetings);
        //첫번째 회의 등록
        pq.add(meetings.get(0).endTime);
        for (int i = 1; i < N; i++) {
            Integer possibleStartTime = pq.peek();
            int curMeetingStartTime = meetings.get(i).startTime;
            //can concat
            if (possibleStartTime <= curMeetingStartTime) {
                pq.poll();
                pq.add(meetings.get(i).endTime);
            }
            //cannot concat
            else {
                pq.add(meetings.get(i).endTime);
            }
        }
        bw.write(pq.size() + "");
        bw.flush();

    }

    static class Meeting implements Comparable<Meeting>{
        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            this.endTime = endTime;
            this.startTime = startTime;
        }

        @Override
        public int compareTo(Meeting o) {
            return startTime - o.startTime;
        }
    }

}
