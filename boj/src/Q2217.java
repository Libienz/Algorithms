import java.util.*;
import java.io.*;

public class Q2217 {

    private static int N;
    private static ArrayList<Integer> tws;

    private static int totalWeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        //요소 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        tws = new ArrayList<>();

        //모든 경우는 각 로프가 가장 약한 로프인 경우로 나뉠 수 있다.
        //case 1: 1번 로프가 가장 약한 로프인 경우
        //case 2: 2번 로프가 가장 약한 로프인 경우 ....
        //case 1에서 최대한의 이득을 내려면 자기보다 강한 로프를 무작정 많이 고르면 된다.

        for (int i = 0; i < N; i++) {
            int curWeight = Integer.parseInt(br.readLine());
            tws.add(curWeight);
        }
        Collections.sort(tws);
        for (int i = 0; i < N; i++) {
            int tolerableWeight = (N - i) * tws.get(i);
            if (totalWeight < tolerableWeight) {
                totalWeight = tolerableWeight;
            }
        }


        bw.write(totalWeight + "");
        bw.flush();
    }



}
