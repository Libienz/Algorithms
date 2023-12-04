import java.util.*;
import java.io.*;

public class Main {

    private static int resTime = Integer.MAX_VALUE;
    private static int resHeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        //map 초기화 및 지도에서 가장 높은 곳과 가장 낮은 곳 계산
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
                if (map[i][j] < minHeight) {
                    minHeight = map[i][j];
                }
            }
        }

        //map의 높이를 i로 하기로 했을 때 걸리는 비용 계산
        for (int i = minHeight; i <= maxHeight; i++) {
            //map의 높이를 i로 하기로 했을 때 제거해야 하는 벽돌 개수
            int removeCount = calcRemoveCount(map, i);
            //map의 높이를 i로 하기로 했을 때 쌓아야 하는 벽돌 개수
            int stackCount = calcStackCount(map, i);

            //쌓아야 하는 벽돌 개수 보다 부족할 때는 i 높이로 평탄화 할 수 없다.
            if (removeCount + B < stackCount) {
                continue;
            }

            //쌓을 수 있는 경우는 걸리는 시간과 높이를 계산 후 최소인지 계산
            int time = removeCount * 2 + stackCount;
            if (time < resTime) {
                resTime = time;
                resHeight = i;
            } else if (time == resTime) {
                if (resHeight < i) {
                    resHeight = i;
                }
            }
        }

        bw.write(String.format("%d %d", resTime, resHeight));
        bw.flush();
    }

    public static int calcRemoveCount(int[][] map, int height) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > height) {
                    count += (map[i][j] - height);
                }
            }
        }
        return count;
    }

    public static int calcStackCount(int[][] map, int height) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] < height) {
                    count += (height - map[i][j]);
                }
            }
        }
        return count;
    }


}