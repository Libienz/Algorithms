import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] rooms = new int[k + 1][n + 1];

            //0층의 j호에는 j명이 산다.
            for (int j = 1; j <= n; j++) {
                rooms[0][j] = j;
            }
            fillRooms(rooms);
            bw.write(String.valueOf(rooms[k][n] + "\n"));
            bw.flush();
        }
    }

    public static void fillRooms(int[][] room) {

        for (int i = 1; i < room.length; i++) {
            for (int j = 1; j < room[0].length; j++) {
                room[i][j] = calcDownFloor(room, i, j);
            }
        }
    }

    public static int calcDownFloor(int[][] room, int fl, int rn) {
        int sum = 0;
        for (int i = 1; i <= rn; i++) {
            sum += room[fl - 1][i];
        }
        return sum;
    }
}

