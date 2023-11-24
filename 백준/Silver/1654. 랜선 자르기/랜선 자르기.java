import java.util.*;
import java.io.*;

public class Main {
    private static int K;
    private static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken()); //가지고 있는 랜선 개수
        N = Integer.parseInt(st.nextToken()); //필요한 랜선의 개수
        List<Integer> cables = new ArrayList<>(); //초기 랜선 정보


        for (int i = 0; i < K; i++) {
            cables.add(Integer.parseInt(br.readLine()));
        }

        Long min = 0L;
        Long max = (long) Integer.MAX_VALUE;
        Long mid;
        while (min <= max) {
            mid = (max + min) / 2;
            if (affordableLength(mid, cables)) {
                min = mid + 1;
            } else {
                max = mid-1;
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }

    public static boolean affordableLength(Long cutLength, List<Integer> cables) {
        Long count = 0L;
        for (int cable : cables) {
            count += cable / cutLength;
        }
        if (count >= N) {
            return true;
        }
        return false;
    }
}