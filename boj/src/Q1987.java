import java.util.*;

public class Q1987 {

    static int r;
    static int c;
    static char[][] board;
    static Set<Character> set;
    static int maxMv;
    public static boolean isAvailableIdx(int row, int col) {
        if (0 <= row && row < r && 0 <= col && col < c) {
            return true;
        }
        return false;
    }
    public static void dfs(int r, int c, int lev) {

        int row = r;
        int col = c;
        if (maxMv < lev) {
            maxMv = lev;
        }

        //상
        row = row -1;
        if (isAvailableIdx(row, col) && !set.contains(board[row][col])) {
            set.add(board[row][col]);
            dfs(row, col, lev + 1);
            set.remove(board[row][col]);
        }
        //하
        row = row + 2;
        if (isAvailableIdx(row, col) && !set.contains(board[row][col])) {
            set.add(board[row][col]);
            dfs(row, col, lev + 1);
            set.remove(board[row][col]);
        }
        //좌
        row = row - 1;
        col = col - 1;
        if (isAvailableIdx(row, col) && !set.contains(board[row][col])) {
            set.add(board[row][col]);
            dfs(row, col, lev + 1);
            set.remove(board[row][col]);
        }
        //우
        col = col + 2;
        if (isAvailableIdx(row, col) && !set.contains(board[row][col])) {
            set.add(board[row][col]);
            dfs(row, col, lev + 1);
            set.remove(board[row][col]);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();

        //r by c의 board가 있다.
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = sc.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        //0,0에 있는 알파벳은 말임
        //말은 상하좌우로 움직일 수 있지만 한번 지나온 곳의 알파벳과 같은 알파벳을 가진 곳으로는 향할 수 없다.

        set = new HashSet<>();
        maxMv = Integer.MIN_VALUE;
        set.add(board[0][0]);
        dfs(0, 0, 1);

        System.out.println(maxMv);


    }


}
