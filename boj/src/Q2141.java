import java.util.*;
import java.io.*;

//결정 알고리즘 시간초과
public class Q2141 {

    private static int N;
    private static int[] vPops; //마을 인구수
    private static int[] vLocs; //마을 위치
    private static int leftVillageLoc = Integer.MAX_VALUE;
    private static int rightVillageLoc = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        vLocs = new int[N];
        vPops = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()); //마을의 위치
            int a = Integer.parseInt(st.nextToken()); //마을의 인구수

            //제일 왼쪽 마을과 오른쪽 마을 저장해놓기
            if (x < leftVillageLoc) {
                leftVillageLoc = x;
            }
            if (x > rightVillageLoc) {
                rightVillageLoc = x;
            }
            vPops[i] = a;
            vLocs[i] = x;
        }

        int res = Integer.MAX_VALUE;
        int postLoc = 0;
        //제일 왼쪽에 위치 한 마을과 제일 오른쪽에 있는 마을 사이에 답이 있다.
        for (int i = leftVillageLoc; i <= rightVillageLoc; i++) {

            //i 위치에 우체국을 세울 경우 각 사람들까지의 거리의 합
            int td = 0;
            for (int j = 0; j < vLocs.length; j++) {
                int dist = Math.abs(vLocs[j] - i);
                td += dist * vPops[j];
            }
            if (td < res) {
                res = td;
                postLoc = i;
            }
        }
        bw.write(postLoc +"");
        bw.flush();

    }
}
