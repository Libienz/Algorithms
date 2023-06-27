import java.io.*;
import java.util.*;

class Co {
    int r, c;

    boolean in = false;
    public Co(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Co{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}
public class Q13459 {

    static char[][] board;
    static int n;
    static int m;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};

    public static Co roll(Co pos, int rw, int cw, int nr, int nc) {
        Co tmp = new Co(pos.r, pos.c);
        while (board[tmp.r + rw][tmp.c + cw] != '#') {
            if (tmp.r + rw == nr && tmp.c + cw == nc) {
                return tmp;
            }
            tmp.r = tmp.r + rw;
            tmp.c = tmp.c + cw;

            if (board[tmp.r][tmp.c] == 'O') {
                tmp.in = true;
            }
        }
        return tmp;
    }

    public static int bfs(Co rc, Co bc) { //빨간공의 좌표와 파란공의 좌표를 받는다.

        Queue<Co> q = new LinkedList<>();
        int level = 0;
        q.offer(rc);
        q.offer(bc);

        while (level < 10) {
            int len = q.size();
            for (int i = 0; i < len / 2; i++) {

                //큐에 들어있는 빨간공위치와 파란공위치를 꺼낸다.
                Co curRc = q.poll();
                Co curBc = q.poll();

                Co newRc = curRc;
                Co newBc = curBc;

                //상하좌우 기울인 포지션을 q에 넣는다.


                //왼쪽 기울이기
                if (curRc.c < curBc.c) { //빨간공이 더 왼쪽에 있어서 먼저 움직인다.

                    //빨간공 움직이기
                    newRc = roll(curRc, 0, -1, -1, -1);
                    //빨간공 움직일 수 있을 만큼 움직인 후 파란공 움직이기
                    if (newRc.in) {
                        newBc = roll(curBc, 0, -1, -1, -1);
                    }
                    else {
                        newBc = roll(curBc, 0, -1, newRc.r, newRc.c);
                    }


                }
                else { //파란공이 더 왼쪽에 있어서 먼저 움직인다.
                    newBc = roll(curBc, 0, -1, -1,-1);
                    //파란공 움직일 수 있을 만큼 움직인 후 빨간공 움직이기
                    if (newBc.in) {
                        newRc = roll(curRc, 0, -1, -1, -1);
                    } else {
                        newRc = roll(curRc, 0, -1, newBc.r, newBc.c);
                    }

                }
                if (!newRc.in && !newBc.in) { //빨공도 파공도 구멍에 안들어갔다면
                    q.offer(newRc);
                    q.offer(newBc);
                }
                else if (newRc.in && !newBc.in) {
//                    System.out.println("newBc = " + newBc);
//                    return level+1;
                    return 1;
                }


                //오른쪽 기울이기
                if (curRc.c < curBc.c) { //파란공이 더 오른쪽에 있어서 먼저 움직인다.

                    //파란공 움직이기
                    newBc = roll(curBc, 0, 1, -1,-1);
                    //파란공 움직일 수 있을 만큼 움직인 후 빨간공 움직이기
                    if (newBc.in) {
                        newRc = roll(curRc, 0, 1, -1, -1);
                    }
                    else {
                        newRc = roll(curRc, 0, 1, newBc.r, newBc.c);
                    }

                }
                else { //파란공이 더 왼쪽에 있어서 나중에 움직인다.
                    newRc = roll(curRc, 0, 1, -1,-1);
                    //빨간공 움직일 수 있을 만큼 움직인 후 파란공 움직이기
                    if (newRc.in) {
                        newBc = roll(curBc, 0, 1, -1, -1);
                    }
                    else {
                        newBc = roll(curBc, 0, 1, newRc.r, newRc.c);

                    }

                }
                if (!newRc.in && !newBc.in) {
                    q.offer(newRc);
                    q.offer(newBc);
                }
                else if (newRc.in && !newBc.in) {
//                    System.out.println("newBc = " + newBc);
//                    return level+1;
                    return 1;
                }
                //위로 기울이기
                if (curRc.r < curBc.r) { //빨공이 더 위쪽에 있어서 먼저 움직인다.

                    //빨공 움직이기
                    newRc = roll(curRc, -1, 0, -1,-1);

                    //빨공 움직일 수 있을 만큼 움직인 후 파공 움직이기
                    if (newRc.in) {
                        newBc = roll(curBc, -1, 0, -1, -1);
                    } else {
                        newBc = roll(curBc, -1, 0, newRc.r, newRc.c);
                    }

                }
                else { //파공이 더 위쪽에 있어서 먼저 움직인다.
                    newBc = roll(curBc, -1, 0, -1,-1);
                    //파공 움직일 수 있을 만큼 움직인 후 빨공 움직이기
                    if (newBc.in) {
                        newRc = roll(curRc, -1, 0, -1, -1);
                    } else {
                        newRc = roll(curRc, -1, 0, newBc.r, newBc.c);

                    }
                }
                if (!newRc.in && !newBc.in) {
                    q.offer(newRc);
                    q.offer(newBc);
                }
                else if (newRc.in && !newBc.in) {
//                    System.out.println("newBc = " + newBc);
//                    return level+1;
                    return 1;
                }
                //아래로 기울이기
                if (curRc.r < curBc.r) { //파공이 더 아래에 있어서 먼저 움직인다.

                    //파공 움직이기
                    newBc = roll(curBc, 1, 0, -1,-1);
                    //파공 움직일 수 있을 만큼 움직인 후 빨공 움직이기
                    if (newBc.in) {
                        newRc = roll(curRc, 1, 0, -1, -1);
                    }
                    else {
                        newRc = roll(curRc, 1, 0, newBc.r, newBc.c);
                    }

                }
                else { //빨공이 더 아래에 있어서 먼저 움직인다.
                    newRc = roll(curRc, 1, 0, -1,-1);
                    //빨공 움직일 수 있을 만큼 움직인 후 파공 움직이기
                    if (newRc.in) {
                        newBc = roll(curBc, 1, 0, -1, -1);

                    } else {
                        newBc = roll(curBc, 1, 0, newRc.r, newRc.c);

                    }

                }
                if (!newRc.in && !newBc.in) {
                    q.offer(newRc);
                    q.offer(newBc);
                }
                else if (newRc.in && !newBc.in) {
//                    System.out.println("newBc = " + newBc);
//                    return level +1;
                    return 1;
                }

            }
            level++;
        }
        return 0;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //보드의 row size
        m = sc.nextInt(); //보드의 col size
        board = new char[n][m];

        Co rc = null;
        Co bc = null;

        for (int i = 0; i < n; i++) {
            String next = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = next.charAt(j);
                if (next.charAt(j) == 'B') {
                    bc = new Co(i, j);
                }
                if (next.charAt(j) == 'R') {
                    rc = new Co(i, j);
                }
            }
        }

        System.out.println(bfs(rc, bc));

    }
}
