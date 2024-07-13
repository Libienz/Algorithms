import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int SUDOKU_SIZE = 9;

    private static int[][] puzzle = new int[SUDOKU_SIZE][SUDOKU_SIZE];
    private static boolean solved;
    private static List<Point> emptyList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            String line = br.readLine();
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                puzzle[i][j] = line.charAt(j) - 48;
                if (puzzle[i][j] == 0) {
                    emptyList.add(new Point(i, j));
                }
            }
        }

        solveSudoku(0, bw);
    }

    public static void solveSudoku(int emptyIdx, BufferedWriter bw) throws IOException {
        if (emptyIdx >= emptyList.size()) {
            solved = true;
            for (int i = 0; i < SUDOKU_SIZE; i++) {
                for (int j = 0; j < SUDOKU_SIZE; j++) {
                    bw.write(String.valueOf(puzzle[i][j]));
                }
                if (i < SUDOKU_SIZE - 1) {
                    bw.newLine();
                }
            }
            bw.flush();
            return;
        }

        Point point = emptyList.get(emptyIdx);
        for (int i = 1; i <= 9; i++) {
            if (validated(point.r, point.c, i)) {
                puzzle[point.r][point.c] = i;
                if (solved) {
                    return;
                }
                solveSudoku(emptyIdx + 1, bw);
                puzzle[point.r][point.c] = 0;
            }
        }
    }

    private static boolean validated(int row, int col, int num) {
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (puzzle[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (puzzle[i][col] == num) {
                return false;
            }
        }

        int bs = (row / 3) * 3;
        int bc = (col / 3) * 3;

        for (int i = bs; i < bs + 3; i++) {
            for (int j = bc; j < bc + 3; j++) {
                if (puzzle[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
