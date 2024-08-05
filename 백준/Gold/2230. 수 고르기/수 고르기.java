import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int minDiff = Integer.MAX_VALUE;
    private static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            arr.add(number);
        }
        Collections.sort(arr);

        int lt = 0;
        int rt = 0;
        while (lt <= rt) {
            int diff = arr.get(rt) - arr.get(lt);
            if (diff >= M) {
                minDiff = Math.min(diff, minDiff);
                lt++;
            } else {
                rt++;
            }
            if (lt >= N || rt >= N) {
                break;
            }
        }
//
//        for (int i = 0; i < N; i++) {
//            for (int gap = 0; i + gap < N; gap++) {
//                int diff = arr.get(i + gap) - arr.get(i);
//                if (diff >= M) {
//                    minDiff = Math.min(minDiff, diff);
//                    break;
//                }
//            }
//        }

        bw.write(String.valueOf(minDiff));
        bw.flush();
    }
}

