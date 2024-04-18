import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int[] moveR = {0, 0, 1, -1};
    private static int[] moveC = {1, -1, 0, 0};
    private static char[][] grid;
    private static boolean[][] redGreenBlindVisited;
    private static boolean[][] normalPeopleVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        redGreenBlindVisited = new boolean[n][n];
        normalPeopleVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        bw.write(String.valueOf(countAreaFromNormal()));
        bw.newLine();
        bw.write(String.valueOf(countAreaFromRedGreenBlindness()));
        bw.flush();
    }

    public static int countAreaFromNormal() {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (normalPeopleVisited[i][j]) {
                    continue;
                }
                normalPeopleVisited[i][j] = true;
                dfs(i, j, grid[i][j]);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int r, int c, char color) {
        for (int i = 0; i < 4; i++) {
            int nr = r + moveR[i];
            int nc = c + moveC[i];
            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid.length) {
                continue;
            }
            if (grid[nr][nc] == color && !normalPeopleVisited[nr][nc]) {
                normalPeopleVisited[nr][nc] = true;
                dfs(nr, nc, color);
            }
        }
    }

    public static int countAreaFromRedGreenBlindness() {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (redGreenBlindVisited[i][j]) {
                    continue;
                }
                redGreenBlindVisited[i][j] = true;
                dfsRedGreenBlind(i, j, grid[i][j]);
                count++;
            }
        }
        return count;
    }

    public static void dfsRedGreenBlind(int r, int c, char color) {
        for (int i = 0; i < 4; i++) {
            int nr = r + moveR[i];
            int nc = c + moveC[i];
            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid.length) {
                continue;
            }
            if (!redGreenBlindVisited[nr][nc]) {
                if ((color == 'R' || color == 'G') && grid[nr][nc] == 'B') {
                    continue;
                }
                if (color == 'B' && grid[nr][nc] != 'B') {
                    continue;
                }
                redGreenBlindVisited[nr][nc] = true;
                dfsRedGreenBlind(nr, nc, color);
            }
        }
    }
}
