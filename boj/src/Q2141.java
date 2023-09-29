import java.util.*;
import java.io.*;

public class Q2141 {

    private static int N;
    private static ArrayList<Village> villages = new ArrayList<>();
    private static int leftVillageLoc = Integer.MAX_VALUE;
    private static int rightVillageLoc = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        long totalPop = 0L;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()); //마을의 위치
            int a = Integer.parseInt(st.nextToken()); //마을의 인구수
            totalPop += a;
            Village v = new Village(x, a);
            villages.add(v);
        }

        //위치 순 정렬
        Collections.sort(villages);
        int res = Integer.MAX_VALUE;

        long leftPop = 0;
        long postLoc = 0;
        for (int i = 0; i < villages.size(); i++) {
            leftPop += villages.get(i).population;

            if ((totalPop + 1) / 2 <= leftPop) {

                postLoc = villages.get(i).location;
                break;
            }
        }

        bw.write(postLoc +"");
        bw.flush();

    }

    static class Village implements Comparable<Village> {
        private long location;
        private long population;

        public Village(long location, long population) {
            this.location = location;
            this.population = population;
        }

        @Override
        public int compareTo(Village o) {
            return (int) (this.location - o.location);
        }
    }
}
