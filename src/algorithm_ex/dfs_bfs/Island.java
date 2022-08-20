package algorithm_ex.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island {

    static int N;
    static boolean break_flag;

    public static boolean allZero(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isAble(int i, int j) {

        if (i >= N || j >= N || i < 0 || j < 0 ) { // 인덱스 벗어남
            return false;
        }
        else  {
            return true;
        }

    }
    public static int countIslandBFS(int[][] map) {


        Queue<Coord> Q = new LinkedList<>();
        int level = 0;



        while (!allZero(map)) {
            //1인 지점 하나 잡아낸다
            //이후 그 지점과 연결된 곳들을 하나의 섬으로 취급할 것
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 1) {
                        Q.add(new Coord(i, j));
                        break_flag = true;
                        break;
                    }
                }
                if (break_flag) {
                    break;
                }
            }
            break_flag = false;
            //System.out.println(allZero(map));
            while (!Q.isEmpty()) {
                int len = Q.size();
                for (int i = 0; i < len; i++) {
                    Coord cur = Q.poll();
                    map[cur.row][cur.col] = 0;

                    if (isAble(cur.row-1,cur.col) && map[cur.row-1][cur.col] == 1) { //상
                        Q.add(new Coord(cur.row-1,cur.col));
                    }
                    if (isAble(cur.row+1,cur.col) &&map[cur.row+1][cur.col] == 1) { //하
                        Q.add(new Coord(cur.row+1,cur.col));
                    }
                    if (isAble(cur.row,cur.col-1) &&map[cur.row][cur.col-1] == 1) { //좌
                        Q.add(new Coord(cur.row,cur.col-1));
                    }
                    if (isAble(cur.row,cur.col+1) &&map[cur.row][cur.col+1] == 1) { //우
                        Q.add(new Coord(cur.row,cur.col+1));
                    }
                    if (isAble(cur.row-1,cur.col-1) && map[cur.row-1][cur.col-1] == 1) { //좌상
                        Q.add(new Coord(cur.row-1,cur.col-1));
                    }
                    if (isAble(cur.row+1,cur.col-1) && map[cur.row+1][cur.col-1] == 1) { //좌하
                        Q.add(new Coord(cur.row+1,cur.col-1));
                    }
                    if (isAble(cur.row-1,cur.col+1) && map[cur.row-1][cur.col+1] == 1) { //우상
                        Q.add(new Coord(cur.row-1,cur.col+1));
                    }
                    if (isAble(cur.row+1,cur.col+1) && map[cur.row+1][cur.col+1] == 1) { //우하
                        Q.add(new Coord(cur.row+1,cur.col+1));
                    }


                }
            }
            level++;
            //System.out.println("level = " + level);
        }
        return level;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] map = new int[N][N];

        //init map
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int answer = countIslandBFS(map);
        System.out.println(answer);



    }

}
