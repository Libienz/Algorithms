import java.util.*;
import java.io.*;

public class Main {

    private static int T;
    private static int W;
    private static int res = Integer.MIN_VALUE;
    private static int[] pos = new int[1001];

    private static int[][] dp = new int[1001][31];



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken()); //자두는 T초 동안 떨어진다.
        W = Integer.parseInt(st.nextToken()); //최대 W번 만큼만 움직인다.

        for (int i = 0; i < T; i++) {
            //i초에 자두는 pos[i] 위치에 떨어진다.
            pos[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i <= W; i++) {
            //짝수번 움직여서 제자리로 왔을 때
            if (i % 2 == 0) {
                if (pos[0] == 1) {
                    dp[0][i] = 1;

                } else {
                    dp[0][i] = 0;
                }
            }
            //홀수번 움직여서 2번 나무 위치로 갔을 대
            else {
                if (pos[0] != 1) {
                    dp[0][i] = 1;
                } else {
                    dp[0][i] = 0;
                }
            }
        }

        for (int t = 1; t < T; t++) {
            int dropPos = pos[t];
            for (int w = 0; w <= W; w++) {
                if (w == 0) {
                    dp[t][w] = dp[t - 1][0];
                    if (dropPos == 1) {
                        dp[t][w] += 1;
                    }
                    continue;
                }
                //현재 위치 는 1
                if (w % 2 == 0) {
                    dp[t][w] = Math.max(dp[t - 1][w - 1], dp[t - 1][w]);
                    if (dropPos == 1) {
                        dp[t][w] += 1;
                    }
                }
                //현재 위치는 2
                else {
                    dp[t][w] = Math.max(dp[t - 1][w - 1], dp[t - 1][w]);
                    if (dropPos == 2) {
                        dp[t][w] += 1;
                    }
                }
            }
        }
//        System.out.println("dp[1][0] = " + dp[1][0]);
//        System.out.println("dp[2][0] = " + dp[2][0]);
//        for (int i = 0; i < T; i++) {
//            for (int j = 0; j <= W; j++) {
//                System.out.println(i+" time " +j+" move ");
//                System.out.println(dp[i][j]);
//
//            }
//        }
//        dfs(0, 0, 1, 0);
        for (int i = 0; i <= W; i++) {
            res = Math.max(res, dp[T - 1][i]);
        }
        bw.write(res + "");
        bw.newLine();
        bw.flush();


    }


    /**
     *
     * @param t t초에 떨어질 자두가 떨어지기 직전
     * @param cnt 현재까지 받은 자두 개수
     * @param hp 현재 사람의 위치
     * @param sc 현재까지 위치를 바꾼 횟수
     */
    public static void dfs(int t, int cnt, int hp, int sc) {

        if (t > T) {
            if (cnt > res) {
                res = cnt;
            }
            return;
        } else {
            //자두가 떨어지는 위치
            int dropPos = pos[t];
            //위치를 옮긴다.
            if (sc + 1 <= W) {
                int newPos = (hp == 1) ? 2 : 1;
                if (newPos == dropPos) {
                    dfs(t + 1, cnt + 1, newPos, sc + 1);
                } else {
                    dfs(t + 1, cnt, newPos, sc + 1);
                }
            }
            //위치를 옮기지 않는다.
            if (hp == dropPos) {
                dfs(t + 1, cnt + 1, hp, sc);
            } else {
                dfs(t + 1, cnt, hp, sc);
            }

        }
    }
}
