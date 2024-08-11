import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int BOARD_WIDTH = 3;
    private static final int[] COLUMN_MOVE_WEIGHT = {-1, 0, 1};

    private static int N;
    private static int[][] board;
    private static int[][] maxDp;
    private static int[][] minDp;
    private static int minScore = Integer.MAX_VALUE;
    private static int maxScore = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][BOARD_WIDTH];
        maxDp = new int[N][BOARD_WIDTH];
        minDp = new int[N][BOARD_WIDTH];

        for (int i = 0; i < N; i++) {
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BOARD_WIDTH; j++) {
                int score = Integer.parseInt(st.nextToken());
                board[i][j] = score;
            }
        }

        for (int i = 0; i < BOARD_WIDTH; i++) {
            maxDp[0][i] = board[0][i];
            minDp[0][i] = board[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                for (int k = 0; k < 3; k++) {
                    int prevColumn = j + COLUMN_MOVE_WEIGHT[k];
                    if (prevColumn < 0 || prevColumn >= BOARD_WIDTH) {
                        continue;
                    }
                    maxDp[i][j] = Math.max(maxDp[i - 1][prevColumn] + board[i][j], maxDp[i][j]);
                    minDp[i][j] = Math.min(minDp[i - 1][prevColumn] + board[i][j], minDp[i][j]);
                }
            }
        }

        for (int i = 0; i < BOARD_WIDTH; i++) {
            minScore = Math.min(minScore, minDp[N - 1][i]);
            maxScore = Math.max(maxScore, maxDp[N - 1][i]);
        }

        bw.write(maxScore + " " + minScore);
        bw.flush();
    }
}

