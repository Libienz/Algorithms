import java.util.*;
import java.io.*;

public class Q16918 {

    private static int R;
    private static int C;
    private static int N;
    private static char[][] map;
    private static int[][] bombTimer;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        bombTimer = new int[R][C];
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        bomber();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(map[i][j] + "");
            }
            bw.newLine();
        }
        bw.flush();


    }
    public static void bomber() {
        int sec = 0;
        //1초 동안 아무것도 하지 않음
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    bombTimer[i][j] = 2;
                }
            }
        }
        sec = 1;

        while (sec != N) {

//            System.out.println("sec = " + sec);
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
            if (sec % 2 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombTimer[i][j] = 3;
                        } else {
                            bombTimer[i][j] -= 1;
                        }

                    }
                }
                sec++;
                continue;
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (bombTimer[i][j] > 0) {
                        bombTimer[i][j] -= 1;
                        //explode 4 way
                        if (bombTimer[i][j] == 0) {
                            map[i][j] = '.';
                            for (int k = 0; k < 4; k++) {
                                int er = i + moveR[k];
                                int ec = j + moveC[k];
                                if (er >= 0 && er < R && ec >= 0 && ec < C) {
                                    map[er][ec] = '.';
                                }
                            }
                        }
                    }
                }
            }
            sec++;
        }

    }
}

