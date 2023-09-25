import java.util.*;
import java.io.*;

public class Q1092 {

    private static int N;
    private static PriorityQueue<Integer> crainWeights;
    private static ArrayList<Integer> tmp;
    private static int M;
    private static Integer[] boxWeights;
    private static boolean[] boxMoved;
    private static int liftedCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        crainWeights = new PriorityQueue<>(Collections.reverseOrder());
        tmp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int cw = Integer.parseInt(st.nextToken());
            crainWeights.add(cw);
            tmp.add(cw);
        }
        
        M = Integer.parseInt(br.readLine());
        boxWeights = new Integer[M];
        boxMoved = new boolean[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            boxWeights[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(boxWeights, Comparator.reverseOrder());

        //박스 무게가 가장 강한 크레인도 못옮기는 무게면 return
        if (boxWeights[0] > crainWeights.peek()) {
            bw.write(-1 + "");
            bw.flush();
            return;
        }
        int min = 0;

        while (liftedCount < M) {

            crainWeights = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                crainWeights.add(tmp.get(i));
            }
            for (int i = 0; i < M; i++) {
                //이미 옮겨진 박스인지 확인
                if (boxMoved[i]) {
                    continue;
                }

                int boxWeight = boxWeights[i];

                //박스를 옮길 수 있는 크레인 찾기

                if (crainWeights.peek() == null) {
                    continue;
                }
                if (crainWeights.peek() >= boxWeight) {
                    liftedCount++;
                    boxMoved[i] = true;
                    crainWeights.poll();
                }

            }

            min++;
        }

        bw.write(min + "");
        bw.flush();

    }

}
