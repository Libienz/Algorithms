import java.util.*;
import java.io.*;

public class Q13305 {

    private static int N; //도시의 개수
    private static Long[] dist;
    private static Long[] price;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dist = new Long[N];
        price = new Long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dist[0] = 0L;
        for (int i = 1; i < N; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        Long cost = 0L; //현재까지 사용한 비용
        int cp = 0; //현재 위치
        while (cp != N - 1) {

            //현재보다 더 싼 기름집을 찾는다.
            int cheaper = cp;
            for (int j = cp + 1; j < N; j++) {
                //찾음
                if (price[j] < price[cp]) {
                    cheaper = j;
                    break;
                }

            }
//            System.out.println("cheaper = " + cheaper);
            //못찾음
            if (cheaper == cp) {
                Long leftDist = 0L;
                for (int j = cp + 1; j < N; j++) {
                    leftDist += dist[j];
                }
                cost += leftDist * price[cp];

                break;
            }
            //더 싼 기름집을 갈 수 있을 만큼만 기름 채우고 싼곳으로 이동
            int distToCheaper = 0;
            for (int j = cp + 1; j <= cheaper; j++) {
                distToCheaper += dist[j];
            }
            cost += distToCheaper * (price[cp]);
            cp = cheaper;
        }

        bw.write(cost + "");
        bw.flush();




    }


}
