import java.util.*;

class Coord {
    int floor;
    int row;
    int col;

    public Coord(int floor, int row, int col) {
        this.floor = floor;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "floor=" + floor +
                ", row=" + row +
                ", col=" + col +
                '}';
    }
}
public class Q6593 {

    static char[][][] map;
    static boolean[][][] visited;
    static int[] moveX = {-1, 1, 0, 0, 0, 0};
    static int[] moveY = {0, 0, -1, 1, 0, 0};
    static int[] moveZ = {0, 0, 0, 0, -1, 1};

    static int l;
    static int r;
    static int c;

    public static boolean isAvailableCoord(int floor, int row, int col) {
        if (floor >= 0 && row >= 0 && col >= 0 && floor < l && row < r && col < c) {
            return true;
        }
        return false;
    }

    public static int bfs(int sf, int sr, int sc) {

        Queue<Coord> q = new LinkedList<>();
        Coord start = new Coord(sf, sr, sc);
        q.add(start);
        int step = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Coord cur = q.poll();
//                System.out.println("cur = " + cur);
//                visited[cur.floor][cur.row][cur.col] = true;
                if (map[cur.floor][cur.row][cur.col] == 'E') {
                    q.clear();
                    return step;
                }
                int nf, nr, nc;


                for (int m = 0; m < moveX.length; m++) {
                    nf = cur.floor + moveZ[m];
                    nr = cur.row + moveY[m];
                    nc = cur.col + moveX[m];
                    if (isAvailableCoord(nf, nr, nc) && map[nf][nr][nc] != '#' && !visited[nf][nr][nc]) {
                        q.add(new Coord(nf, nr, nc));
                        visited[nf][nr][nc] = true;
                    }
                }


            }
            step++;

        }

        return -1;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {

            l = sc.nextInt(); //층 수
            r = sc.nextInt(); //한 층의 행

            if (l == 0 && r == 0 ) {
                break;
            }
            c = sc.nextInt(); //한 층의 열

            map = new char[l][r][c];
            visited = new boolean[l][r][c];

            int stf = -1;
            int str = -1;
            int stc = -1;
            for (int f = 0; f < l; f++) {
                for (int i = 0; i < r; i++) {
                    String next = sc.next();
                    for (int j = 0; j < c; j++) {
                        map[f][i][j] =  next.charAt(j);
                        if (next.charAt(j) == 'S') {
                            stf = f;
                            str = i;
                            stc = j;
                        }
                        visited[f][i][j] = false;
                    }
                }
            }

            int step = bfs(stf, str, stc);
            if (step == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + step + " minute(s).");
            }
        }
//        System.out.println("done");
        return;

    }
}
