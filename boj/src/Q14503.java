import java.util.*;
import java.io.*;

public class Q14503 {

    private static int[][] map;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};
    private static int N;
    private static int M;
    private static int cleaned;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int status = Integer.parseInt(st.nextToken());
                map[i][j] = status;
            }
        }

        runCleaningRobot(sr, sc, sd);
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public static void runCleaningRobot(int sr, int sc, int sd) {
//        System.out.println("sr = " + sr);
//        System.out.println("sc = " + sc);
//        System.out.println("sd = " + sd);

        //현재 칸이 아직 청소되지 않은 경우 현재 칸 청소
        if (map[sr][sc] == 0) {
            map[sr][sc] = -1;
            cleaned++;
        }

        //주변 4칸의 청소여부 파악
        boolean nearAreasAreClean = true;
        for (int i = 0; i < 4; i++) {
            int nr = sr + moveR[i];
            int nc = sc + moveC[i];
            int nd = sd;
            if (!ableToGo(nr, nc)) {
                continue;
            }
            if (map[nr][nc] == 0) {
                nearAreasAreClean = false;
                break;
            }

        }

        //현재 칸 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
        if (nearAreasAreClean) {
            int nr = 0;
            int nc = 0;

            //북 동 남 서
            if (sd == 0) {
                nr = sr + 1;
                nc = sc;
            } else if (sd == 1) {
                nr = sr;
                nc = sc - 1;
            } else if (sd == 2) {
                nr = sr - 1;
                nc = sc;
            } else if (sd == 3) {
                nr = sr;
                nc = sc + 1;
            }
            if (ableToGo(nr, nc)) {
                //go
                runCleaningRobot(nr, nc, sd);
            } else {
                //stop
                return;
            }
        }
        //주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
        else {
            int nr = 0;
            int nc = 0;
            int nd = 0;

            if (sd == 0) {
                nr = sr;
                nc = sc - 1;
                nd = 3;

            } else if (sd == 1) {
                nr = sr - 1;
                nc = sc;
                nd = 0;

            } else if (sd == 2) {
                nr = sr;
                nc = sc + 1;
                nd = 1;

            } else if (sd == 3) {
                nr = sr + 1;
                nc = sc;
                nd = 2;

            }

            if (map[nr][nc] == 0) {
                runCleaningRobot(nr, nc, nd);
            } else {
                runCleaningRobot(sr, sc, nd);
            }

        }
    }

    private static boolean ableToGo(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1) {
            return false;
        }
        return true;
    }
}
