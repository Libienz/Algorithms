import java.io.*;
import java.util.*;

public class Main {

    private static int dr;
    private static int dc;
    private static int hop = 0;
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        dr = Integer.parseInt(st.nextToken());
        dc = Integer.parseInt(st.nextToken());

        Integer size = (int) Math.pow(2, N);


        dfs(0, size-1, 0, size - 1, 0);

        bw.write(String.valueOf(answer));
        bw.flush();

    }



    public static void dfs(int sr, int er, int sc, int ec, int hop) {

        if (sr == er && sc == ec) {
            answer = hop;
            return;
        }
        
        int rm = sr + (er - sr) / 2;
        int cm = sc + (ec - sc) / 2;
        int w = (((er - sr) + 1) * ((er - sr) + 1)) / 4;

        //dr, dc가 어느 사분면에 속하는지 계산
        if (dr <= rm && dc <= cm) { //좌상
            dfs(sr, rm, sc, cm, hop);
        } else if (dr <= rm && dc > cm) { //우상
            dfs(sr, rm, cm + 1, ec, hop + w);
        } else if (dr > rm && dc <= cm) { //좌하
            dfs(rm + 1, er, sc, cm, hop + w * 2);
        } else { //우하
            dfs(rm + 1, er, cm + 1, ec, hop + w * 3);
        }
    }
}