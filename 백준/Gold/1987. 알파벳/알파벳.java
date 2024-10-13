import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int R;
    private static int C;
    private static char[][] grid;
    private static int max = 1;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int initialMask = 1 << (grid[0][0] - 'A');
        dfs(0, 0, initialMask, 1);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int mask, int count) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                int charBit = 1 << (grid[nx][ny] - 'A');
                if ((mask & charBit) == 0) {
                    if (count + 1 > max) {
                        max = count + 1;
                    }
                    dfs(nx, ny, mask | charBit, count + 1);
                }
            }
        }
    }
}
