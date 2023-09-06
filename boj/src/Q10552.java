import java.util.*;
import java.io.*;

public class Q10552 {

    private static int N; //사람 수
    private static int M; //티비 채널 수
    private static int P; //처음 티비 채널 번호
    private static boolean[] visitedChannel;
    private static int[] willStand;

    private static ArrayList<Pensioner> pensioners;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()) - 1;
        M = Integer.parseInt(st.nextToken()) - 1;
        P = Integer.parseInt(st.nextToken()) - 1;

        pensioners = new ArrayList<>();
        visitedChannel = new boolean[M+1];
        willStand = new int[M + 1];
        for (int i = 0; i <= M; i++) {
            willStand[i] = -1;
        }
        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken()) - 1;
            int bi = Integer.parseInt(st.nextToken()) - 1;
            if (willStand[bi] == -1) {
                willStand[bi] = i;
            }
            pensioners.add(new Pensioner(i, ai, bi));
        }


        visitedChannel[P] = true;
        int res = countChannelChange(P);
        bw.write(res + "");
        bw.flush();

    }

    public static int countChannelChange(int startChannel) {
        int curChannel = startChannel;

        int count = 0;
        while (true) {
            if (allHappy(curChannel)) {
                return count;
            } else {
                int standPensioner = willStand[curChannel];
                curChannel = pensioners.get(standPensioner).favoriteChannel;
                if (visitedChannel[curChannel]) {
                    return -1;
                }
                visitedChannel[curChannel] = true;
            }
            count++;

        }
    }

    public static boolean allHappy(int curChannel) {
        if (willStand[curChannel] != -1) {
            return false;
        }
        return true;

    }
    static class Pensioner {
        private int num;
        private int favoriteChannel;
        private int hateChannel;

        public Pensioner(int num, int favoriteChannel, int hateChannel) {
            this.num = num;
            this.favoriteChannel = favoriteChannel;
            this.hateChannel = hateChannel;
        }

        @Override
        public String toString() {
            return "Pensioner{" +
                    "num=" + num +
                    ", favoriteChannel=" + favoriteChannel +
                    ", hateChannel=" + hateChannel +
                    '}';
        }
    }
}
