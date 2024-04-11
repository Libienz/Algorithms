import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] box;
    private static boolean[][][] visited;
    private static final int[] MOVE_X = {-1, 1, 0, 0, 0, 0};
    private static final int[] MOVE_Y = {0, 0, -1, 1, 0, 0};
    private static final int[] MOVE_Z = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int colSize = Integer.parseInt(st.nextToken()); //row
        int rowSize = Integer.parseInt(st.nextToken()); //col
        int height = Integer.parseInt(st.nextToken());

        box = new int[height][rowSize][colSize];
        visited = new boolean[height][rowSize][colSize];

        Queue<Position> q = new LinkedList<>();
        int nonRottenCount = 0;
        for (int h = 0; h < height; h++) {
            for (int i = 0; i < rowSize; i++) {
                String row = br.readLine();
                st = new StringTokenizer(row);
                for (int j = 0; j < colSize; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value == 1) {
                        q.add(new Position(j, i, h));
                        visited[h][i][j] = true;
                    }
                    if (value == 0) {
                        nonRottenCount++;
                    }
                    box[h][i][j] = value;
                }
            }
        }

        if (nonRottenCount == 0) {
            bw.write("0");
            bw.flush();
            return;
        }
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            if (nonRottenCount == 0) {
                bw.write(String.valueOf(level));
                bw.newLine();
                bw.flush();
                return;
            }
            for (int i = 0; i < len; i++) {
                Position cur = q.poll();
                for (int j = 0; j < 6; j++) {
                    int nx = cur.x + MOVE_X[j];
                    int ny = cur.y + MOVE_Y[j];
                    int nz = cur.z + MOVE_Z[j];
                    if (nx < 0 || ny < 0 || nz < 0 || nx >= colSize || ny >= rowSize || nz >= height) {
                        continue;
                    }
                    if (visited[nz][ny][nx]) {
                        continue;
                    }
                    if (box[nz][ny][nx] != 0) {
                        continue;
                    }
                    q.add(new Position(nx, ny, nz));
                    visited[nz][ny][nx] = true;
                    nonRottenCount--;
                }
            }
            level++;
        }
        bw.write("-1");
        bw.flush();
    }

    private static class Position {
        int x;
        int y;
        int z;

        public Position(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
