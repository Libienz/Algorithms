import java.util.*;

//class Node {
//    int r;
//    int c;
//    int val;
//
//    public Node(int r, int c, int val) {
//        this.r = r;
//        this.c = c;
//        this.val = val;
//    }
//}

public class Q2580 {

    static int[][] board;
    static int cnt = 0;
    public static boolean allDone() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //스도쿠 보드 선언 및 초기화
        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        while (!allDone()) {

            //가로 체크
            for (int i = 0; i < 9; i++) {
                //i + 1번째 가로줄에 어떤 숫자들 있는지 s에 담는다.
                Set<Integer> s = new HashSet<>();
                int c = -1;
                for (int j = 0; j < 9; j++) {
                    s.add(board[i][j]);
                    if (board[i][j] == 0) {
                        c = j;
                    }
                }
                //9개가 들어있다면 빈칸이 하나라는 뜻. 즉 채울 수 있음
                if (s.size() == 9) {
                    //1부터 9까지의 수중에 어떤 것이 빠져있는지 s를 통해 체크
                    for (int j = 1; j <= 9; j++) {
                        if (!s.contains(j)) {
                            //j가 빠졌다.
                            board[i][c] = j;
                        }
                    }
                }
            }

            //세로 체크
            for (int i = 0; i < 9; i++) {
                //i + 1번째 세로줄에 어떤 숫자들 있는지 s에 담는다.
                Set<Integer> s = new HashSet<>();
                int r = -1;
                for (int j = 0; j < 9; j++) {
                    s.add(board[j][i]);
                    if (board[j][i] == 0) {
                        r = j;
                    }
                }
                //9개가 들어있다면 빈칸이 하나라는 뜻. 즉 채울 수 있음
                if (s.size() == 9) {
                    //1부터 9까지의 수중에 어떤 것이 빠져있는지 s를 통해 체크
                    for (int j = 1; j <= 9; j++) {
                        if (!s.contains(j)) {
                            //j가 빠졌다.
                            board[r][i] = j;
                        }
                    }
                }
            }
            //사각형 체크
            //9개의 사각형 체크해야 함
//            System.out.println("사각형 시작");
            int rs = 0;
            int cs = 0;
            for (int i = 0; i < 9; i++) {
//                System.out.println("rw = " + rw);
//                System.out.println("cw = " + cw);
                int r = -1;
                int c = -1;
                for (int j = rs; j < rs + 3; j++) {
                    Set<Integer> s = new HashSet<>();
                    for (int k = cs; k < cs + 3; k++) {
                        s.add(board[j][k]);
//                        System.out.println("board[i][j] = " + board[j][k]);
                        if (board[j][k] == 0) {
                            r = j;
                            c = k;
                        }
                    }
                    if (s.size() == 9) {
                        for (int k = 1; k <= 9; k++) {
                            if (!s.contains(k)) {
                                //j가 빠졌다.
                                board[r][c] = k;
                            }
                        }
                    }
                }
                //하나 사각형 다봄
                rs = (rs + 3) % 9;
                cs = (cs + 3) % 9;


            }
            System.out.println("사각형 끝");

            System.out.println("cnt = " + cnt++);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
