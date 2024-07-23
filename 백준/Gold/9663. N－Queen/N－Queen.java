import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int[] board;
    private static int N;
    private static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new int[N];

        placeNQueen(0);
        bw.write(String.valueOf(res));
        bw.flush();
    }

    public static void placeNQueen(int row) {
        if (row == N) {
            res++;
            return;
        }
        for (int i = 0; i < N; i++) {
            board[row] = i;
            if (validateQueenPlacement(row)) {
                placeNQueen(row + 1);
            }
        }
    }

    public static boolean validateQueenPlacement(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i]) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}



