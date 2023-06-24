import java.util.*;

public class Q2468 {

    static int[][] map;
    static boolean[][] visited;
    static int size;

    public static void dfs(int row, int col) {

        int r = row;
        int c = col;

        visited[row][col] = true;

        //상
        r = row - 1;
        c = col;
        if (isValidIdx(r,c) && !visited[r][c] && map[r][c] != 0) {
            dfs(r, c);
        }
        //하
        r = row + 1;
        c = col;
        if (isValidIdx(r,c) && !visited[r][c] && map[r][c] != 0) {
            dfs(r, c);
        }
        //좌
        r = row;
        c = col - 1;
        if (isValidIdx(r,c) && !visited[r][c] && map[r][c] != 0) {
            dfs(r, c);
        }
        //우
        r = row;
        c = col + 1;
        if (isValidIdx(r,c) && !visited[r][c] && map[r][c] != 0) {
            dfs(r, c);
        }
    }

    public static boolean isValidIdx(int r, int c) {
        if (r >= 0 && c >= 0 && r < size && c < size) {
            return true;
        }
        return false;
    }
    public static int countSector(int rain) {

        int res = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] < rain) {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    res += 1;
                    dfs(i, j);
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        map = new int[size][size];
        visited = new boolean[size][size];

        int maxHeight = Integer.MIN_VALUE;
        int maxSectorCount = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }


        for (int i = 0; i < maxHeight; i++) {
            //비가 i높이까지 잠길 정도로 왔을 때 몇개의 안전지대로 나누어지는가?
            visited = new boolean[size][size];
            int cnt = countSector(i);
            if (cnt > maxSectorCount) {
                maxSectorCount = cnt;
            }
        }

        System.out.println(maxSectorCount);


    }
}
