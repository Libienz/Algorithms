import java.util.*;

public class Q2210 {

    private static final int BOARD_WIDTH = 5;
    private static final int BOARD_HEIGHT = 5;
    private static final int MOVE_COUNT = 5;
    static Set<Integer> set;
    static int[][] board;
    static int[] moveR = {0, -1, 1, 0};
    static int[] moveC = {-1, 0, 0, 1};


    public static void dfs(int r, int c, int count, int sequence) {
        if (count == MOVE_COUNT) {
//            int res = sequence / 10;
            set.add(sequence);
        } else {

            for (int i = 0; i < moveR.length; i++) {
                int newR = r + moveR[i];
                int newC = c + moveC[i];
                if (newR >= 0 && newR < BOARD_WIDTH && newC >= 0 && newC < BOARD_HEIGHT) {
                    int newSequence = sequence * 10;
                    newSequence += board[newR][newC];
                    dfs(newR, newC, count + 1, newSequence);
                }
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        board = new int[BOARD_WIDTH][BOARD_HEIGHT];
        set = new HashSet<>();

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                dfs(i, j, 0, board[i][j]);
            }
        }
//        System.out.println(set);
        System.out.println(set.size());

    }
}
