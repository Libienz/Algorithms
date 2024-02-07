import java.io.*;
import java.util.*;

public class Main {
    private static List<Meeting> meetings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Meeting meeting = new Meeting(start, end);
            meetings.add(meeting);
        }

        Collections.sort(meetings);

        int prevMeetingEndTime = -1;
        int meetingCount = 0;
        for (int i = 0; i < meetings.size(); i++) {
            Meeting cur = meetings.get(i);
            if (cur.getStartTime() >= prevMeetingEndTime) {
                meetingCount++;
                prevMeetingEndTime = cur.getEndTime();
            }
        }

        bw.write(String.valueOf(meetingCount));
        bw.flush();
    }

    static class Meeting implements Comparable<Meeting> {
        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public int compareTo(Meeting o) {
            if (o.endTime - this.endTime == 0) {
                return this.startTime - o.startTime;
            }
            return this.endTime - o.endTime;
        }
    }
}