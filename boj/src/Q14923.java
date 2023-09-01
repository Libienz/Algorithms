import java.util.*;

public class Q14923 {

    private static int N;
    private static int M;
    private static int Hx;
    private static int Hy;
    private static int Ex;
    private static int Ey;
    private static int[][] maze;
    private static int[] moveX = {/**-1, 1, -1, 1,**/ 0, 0, -1, 1};
    private static int[] moveY = {/**-1, 1, 1, -1,**/-1, 1, 0, 0};
    private static boolean[][][] visited;


    public static void main(String[] args) {

        //요소들 초기화
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Hx = sc.nextInt() - 1;
        Hy = sc.nextInt() - 1;
        Ex = sc.nextInt() - 1;
        Ey = sc.nextInt() - 1;
        maze = new int[N][M];
        visited = new boolean[2][N][M];
        //미로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        int res = getEscapeCount();
        System.out.println(res);


    }

    //bfs
    public static int getEscapeCount() {
        Queue<Node> q = new LinkedList<>();
        Node startPosition = new Node(Hx, Hy, 1);
        visited[0][Hx][Hy] = true;
        int distance = 0;

        q.add(startPosition);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                int curR = cur.getR();
                int curW = cur.getW();
//                System.out.println("curR = " + curR);
//                System.out.println("curW = " + curW);
//                System.out.println("chance = " + cur.isBreakable());
//                System.out.println();
                //탈출 성공
                if (curR == Ex && curW == Ey) {
                    return distance;
                }
                //4방향으로 이동 가능
                for (int j = 0; j < 4; j++) {
                    int nextR = curR + moveX[j];
                    int nextW = curW + moveY[j];

                    //미로의 범위에 맞는지 체크
                    if (!(nextR >= 0 && nextR < N && nextW >= 0 && nextW < M)) {
                        continue;
                    }
                    //방문 했는 지 체크
                    if ( !visited[cur.getChanceCount()][nextR][nextW]) {
                        //다음 위치가 벽이고
                        if (maze[nextR][nextW] == 1) {
                            //부술 수 있다면
                            if (cur.getChanceCount() > 0) {
                                q.add(new Node(nextR, nextW, cur.getChanceCount() - 1));
                                visited[cur.getChanceCount()][nextR][nextW] = true;
                            }
                            //부술 수 없다면
                            else {
                                continue;
                            }
                        }
                        //다음 위치가 벽이 아니라면
                        else {
                            q.add(new Node(nextR, nextW, cur.getChanceCount()));
                            visited[cur.getChanceCount()][nextR][nextW] = true;

                        }
                    }
                }


            }
            distance++;
        }
        return -1;
    }

    static class Node {
        private int r;
        private int w;
        private int chanceCount;

        public Node(int r, int w, int chanceCount) {
            this.r = r;
            this.w = w;
            this.chanceCount = chanceCount;
        }

        public int getR() {
            return r;
        }
        public int getW() {
            return w;
        }

        public int getChanceCount() {
            return chanceCount;
        }


    }

}
