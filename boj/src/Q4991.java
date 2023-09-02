import java.util.*;

public class Q4991 {

    private static char[][] map;
    private static ArrayList<Node> dirts;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};
    private static ArrayList<ArrayList<Node>> permutatedDirtsList;
    private static int minCount = Integer.MAX_VALUE;
    private static Node startPosition;
    //for memoization
    private static int[][][][] dist;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            int colSize = sc.nextInt();
            int rowSize = sc.nextInt();

            dist = new int[rowSize][colSize][rowSize][colSize];
            //종료 조건
            if (rowSize == 0 && colSize == 0) {
                return;
            }
            //map 초기화
            map = new char[rowSize][colSize];
            dirts = new ArrayList<>();
            for (int i = 0; i < rowSize; i++) {
                String row = sc.next();
                for (int j = 0; j < colSize; j++) {
                    map[i][j] = row.charAt(j);
                    //시작점과 먼지 위치 수집
                    if (map[i][j] == 'o') {
                        startPosition = new Node(i, j);
                    }
                    if (map[i][j] == '*') {
                        dirts.add(new Node(i, j));
                    }
                }
            }

            //Dfs로 먼지들 방문 순서의 모든 경우의 수를 구한다.
            //구한 것은 permutatedDirtsList에 들어있음
            permutatedDirtsList = new ArrayList<>();
            permutationDfs(0, new ArrayList<>());

            for (ArrayList<Node> nodes : permutatedDirtsList) {
                //각 배치로 진행했을 때 hop을 구한다.
                int hop = 0;

                for (int i = 0; i < nodes.size() - 1; i++) {
                    int ch = countHop(nodes.get(i), nodes.get(i + 1));
                    if (ch == -1) {
                        hop = Integer.MAX_VALUE;
                        break;
                    }
                    hop += ch;
                    //shortCut
                    if (hop > minCount) {
                        hop = Integer.MAX_VALUE;
                        break;
                    }
                }
                if (hop < minCount) {
                    minCount = hop;
                }
            }
            if (minCount == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minCount);
            }
            minCount = Integer.MAX_VALUE;

        }

    }

    //n1에서 n2로의 최단 시간
    public static int countHop(Node n1, Node n2) {
        if (dist[n1.r][n1.c][n2.r][n2.c] != 0) {
            return dist[n1.r][n1.c][n2.r][n2.c];
        }
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int hop = 0;
        q.add(n1);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                //도착
                if (cur.r == n2.r && cur.c == n2.c) {
                    dist[n1.r][n1.c][n2.r][n2.c] = hop;
                    dist[n2.r][n2.c][n1.r][n1.c] = hop;
                    return hop;
                }
                //4방향 탐색
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + moveR[j];
                    int nc = cur.c + moveC[j];
                    //범위 벗어났거나 가구에 막혔거나 이미 방문했음
                    if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || visited[nr][nc] || map[nr][nc] == 'x') {
                        continue;
                    }
                    q.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                }

            }
            hop++;
        }
        dist[n1.r][n1.c][n2.r][n2.c] = -1;
        dist[n2.r][n2.c][n1.r][n1.c] = -1;
        return -1;
    }

    public static void permutationDfs(int ch, ArrayList<Node> res) {
        if (ch == dirts.size()) {
            ArrayList<Node> tmp = new ArrayList<>();
            tmp.add(startPosition);
            for (Node node : res) {
                tmp.add(node);
            }
            permutatedDirtsList.add(tmp);

        } else {
            for (int i = 0; i < dirts.size(); i++) {
                if (res.contains(dirts.get(i))) {
                    continue;
                }
                //쓴다.
                res.add(dirts.get(i));
                permutationDfs(ch + 1, res);
                //안쓴다
                res.remove(dirts.get(i));
            }
        }
    }

    static class Node {
        int r;
        int c;

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}