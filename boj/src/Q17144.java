import java.util.*;
import java.io.*;

public class Q17144 {

    private static int R;
    private static int C;
    private static int T;
    private static int[][] map;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, 1, -1};
    private static int[][] weight;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        weight = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < T; i++) {
            weight = new int[R][C];
            diffuseDust();
            addWeight();
            circle();
        }

        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
//                bw.write(map[i][j] + " ");
                if (map[i][j] != -1 && map[i][j] != 0) {
                    res += map[i][j];
                }
            }
//            bw.newLine();
        }

        bw.write(res+"");
        bw.flush();

    }


    public static void addWeight() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = map[i][j] + weight[i][j];
            }
        }
    }

    public static void diffuseDust() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //먼지 있는 곳 찾기
                if (map[i][j] == 0 || map[i][j] == -1) {
                    continue;
                }

                //인접한 4방향 따지기
                for (int k = 0; k < 4; k++) {

                    int nr = i + moveR[k];
                    int nc = j + moveC[k];

                    //공기 청정기가 있거나 칸이 없으면 확산 X
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == -1) {
                        continue;
                    }
                    int diffuseAmount = map[i][j] / 5;
                    //가중 배열에 반영
                    weight[i][j] = weight[i][j] - diffuseAmount;
                    weight[nr][nc] = weight[nr][nc] + diffuseAmount;

                }
            }
        }
    }
    public static void circle() {

        Integer tu = null; //위쪽 공기청정기의 row num
        Integer td = null; //아래쪽 공기청정기의 row num
        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                if (tu == null) {
                    tu = i;
                } else {
                    td = i;
                }
            }
        }

        //위쪽 공기 청정기
        for (int i = tu - 1; i - 1 >= 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i + 1 < C; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i + 1 <= tu; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i - 1 >= 0; i--) {
            map[tu][i] = map[tu][i - 1];
        }
        map[tu][1] = 0;

        //아래쪽 공기 청정기
        for (int i = td + 1; i + 1 < R; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i + 1 < C; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i - 1 >= td; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for (int i = C - 1; i - 1 >= 0; i--) {
            map[td][i] = map[td][i - 1];
        }
        map[td][1] = 0;



    }

}
