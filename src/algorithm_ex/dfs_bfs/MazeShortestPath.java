package algorithm_ex.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
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
public class MazeShortestPath {
    private final static int maze_width = 7;
    private final static int maze_height = 7;
    private final static Coord destination = new Coord(6, 6);
    static int[][] maze;
    static boolean[][] visited;
    public static boolean isableToGo(int i, int j) {

        if (i > 6 || j > 6 || i < 0 || j < 0 || maze[i][j] == 1 || visited[i][j]) { // 인덱스 벗어나거나 이미 방문한 적 있거나 벽일 떄는 못감
            return false;
        }
        else  {
            return true;
        }

    }
    public  static int findShortestPathInMaze(int[][] maze) {

        int level = 0;
        Queue<Coord> Q = new LinkedList<>();
        Q.add(new Coord(0, 0)); //start

        while (!Q.isEmpty()) {
            //System.out.println("MazeShortestPath.findShortestPathInMaze");
            //System.out.println("level = " + level);

            int len = Q.size();
            //System.out.println("len = " + len);
            for (int i = 0; i < len; i++) {
                Coord cur = Q.poll();
                if (cur.row == destination.row && cur.col == destination.col) { // arrived 이거 equals 왜 안되지 까먹었다.. 다시 공부 ㄱㄱ
                    return level;
                }
                if (isableToGo(cur.row-1,cur.col)) { //상
                    Q.add(new Coord(cur.row-1,cur.col ));
                    visited[cur.row - 1][cur.col] = true;
                    //System.out.println(new Coord(cur.row-1,cur.col));
                }
                if (isableToGo(cur.row+1,cur.col )) { //하
                    Q.add(new Coord(cur.row + 1,cur.col ));
                    visited[cur.row + 1][cur.col] = true;
                    //System.out.println(new Coord(cur.row + 1,cur.col ));
                }
                if (isableToGo(cur.row,cur.col-1)) { //좌
                    Q.add(new Coord(cur.row,cur.col-1));
                    visited[cur.row][cur.col - 1] = true;
                    //System.out.println(new Coord(cur.row, cur.col - 1));
                }
                if (isableToGo(cur.row, cur.col+1)) { //우
                    Q.add(new Coord(cur.row, cur.col+1));
                    visited[cur.row][cur.col+1] = true;
                    //System.out.println(new Coord(cur.row, cur.col+1));
                }
            }
            level++;

        }
        return -1;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        maze = new int[maze_height][maze_width];
        visited = new boolean[maze_height][maze_width];
        visited[0][0] = true;

        //maze setting done
        for (int i = 0; i < maze_height; i++) {
            for (int j = 0; j < maze_width; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        System.out.println(findShortestPathInMaze(maze));

    }


}
