import java.util.Scanner;

public class Q16956 {

    static int r;
    static int c;
    static char[][] map;
    static char[][] tmpMap;
    static boolean[][] visited;
    public static boolean isValidIdx(int row, int col) {
        if (row >= 0 && row < r && col >= 0 && col < c) {
            return true;
        }
        return false;
    }
    public static void dfs(int r, int c) {
        visited[r][c] = true;
        if (map[r][c] == 'S') {

        }

        int row, col;

        //상
        row = r - 1;
        col = c;
        if (isValidIdx(row,col) && !visited[row][col] && map[row][col] == '.') {
            map[row][col] = 'F';
            dfs(row, col);
        }
        //하
        row = r + 1;
        col = c;
        if (isValidIdx(row, col) && !visited[row][col] && map[r + 1][c] == '.') {
            map[row][col] = 'F';
            dfs(row, col);
        }
        //좌
        row = r;
        col = c - 1;
        if (isValidIdx(row,col)&& !visited[row][col] && map[r][c-1] == '.') {
            map[row][col] = 'F';
            dfs(row, col);
        }
        //우
        row = r;
        col = c + 1;
        if (isValidIdx(row,col)&& !visited[row][col] && map[r][c+1] == '.') {
            map[row][col] = 'F';
            dfs(row, col);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];
        tmpMap = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String row = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j);
                tmpMap[i][j] = row.charAt(j);

            }
        }


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'W') {
                    //늑대 기준 상
                    if (isValidIdx(i - 1, j) && map[i - 1][j] == 'S') {
                        System.out.println(0);
                        return;
                    }
                    //하
                    if (isValidIdx(i + 1, j) && map[i + 1][j] == 'S') {
                        System.out.println(0);
                        return;
                    }
                    //좌
                    if (isValidIdx(i, j - 1) && map[i][j - 1] == 'S') {
                        System.out.println(0);
                        return;
                    }
                    //우
                    if (isValidIdx(i, j + 1) && map[i][j + 1] == 'S') {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'W') {
                    dfs(i, j);
                }
            }
        }

        //늑대가 갈 수 있는 곳은 전부 F로 찍혀있음

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    //양 기준 상
                    if (isValidIdx(i - 1, j) && map[i - 1][j] == 'F') {
                        tmpMap[i - 1][j] = 'D';
                    }
                    //하
                    if (isValidIdx(i + 1, j) && map[i + 1][j] == 'F') {
                        tmpMap[i + 1][j] = 'D';
                    }
                    //좌
                    if (isValidIdx(i, j - 1) && map[i][j - 1] == 'F') {
                        tmpMap[i][j - 1] = 'D';
                    }
                    //우
                    if (isValidIdx(i, j + 1) && map[i][j + 1] == 'F') {
                        tmpMap[i][j + 1] = 'D';
                    }
                }
            }
        }

//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//        System.out.println();

        System.out.println(1);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(tmpMap[i][j]);

            }
            System.out.println();
        }
    }
}
