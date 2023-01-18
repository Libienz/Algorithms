package algorithm_ex.dfs_bfs;

import java.util.Scanner;

class Coord {
    int row;
    int col;

    public Coord(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return this.row + " " + this.col;
    }
}
public class IslandDFS {

    static int N;
    static int[][] map;
    static int[] for_iter = {-1, 0, 1};

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
    public static Coord getIndexOfOne(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    return new Coord(i, j);
                }
            }
        }
        return null;
    }
    public static void countIslandDFS(int i,int j) {

        //System.out.println("IslandDFS.countIslandDFS");
        //System.out.println("i = " + i);
        //System.out.println("j = " + j);
        map[i][j] = 0;

        for (int dx : for_iter) {
            for (int dy : for_iter) {
                if (i + dx < N && i + dx >= 0 && j + dy < N && j + dy >= 0 && map[i + dx][j + dy] == 1) {

                    countIslandDFS(i + dx, j + dy);
                }
            }
        }
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        //init map
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        while (!allZero(map)) {
            Coord start = getIndexOfOne(map);
            //System.out.println("start = " + start);
            countIslandDFS(start.row, start.col);
            answer++;
        }

        System.out.println(answer);


    }


}
