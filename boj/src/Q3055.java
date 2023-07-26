import java.util.*;

class Node2 {
    private int row;
    private int col;

    public Node2(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
public class Q3055 {

    private static int mapRowSize;
    private static int mapColSize;
    private static char[][] map;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        mapRowSize = sc.nextInt();
        mapColSize = sc.nextInt();

        int startRow = 0;
        int startCol = 0;

        //지도 초기화
        map = new char[mapRowSize][mapColSize];
        for (int i = 0; i < mapRowSize; i++) {
            String row = sc.next();
            for (int j = 0; j < mapColSize; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int minuteForEscape = countMinuteForEscape(startRow, startCol);

        if (minuteForEscape == -1) {
            System.out.println("KAKTUS");
            return;
        }
        System.out.println(minuteForEscape);

    }

    public static int countMinuteForEscape(int sr, int sc) {

        //bfs 요소 초기화
        Queue<Node2> bq = new LinkedList<>(); //비버 위치
        Queue<Node2> wq = new LinkedList<>(); //물 위치
        boolean[][] bieberVisited = new boolean[mapRowSize][mapColSize];
        boolean[][] waterVisited = new boolean[mapRowSize][mapColSize];

        int level = 0;

        //출발지점 큐에 삽입
        bq.add(new Node2(sr, sc));
        bieberVisited[sr][sc] = true;
        //물 있는 위치 큐에 삽입
        for (int i = 0; i < mapRowSize; i++) {
            for (int j = 0; j < mapColSize; j++) {
                if (map[i][j] == '*') {
                    wq.add(new Node2(i, j));
                    waterVisited[i][j] = true;
                }
            }
        }

        while (!bq.isEmpty()) {
            int len = bq.size();
            for (int i = 0; i < len; i++) {
                //현재 위치
                Node2 cur = bq.poll();
                if (map[cur.getRow()][cur.getCol()] == '*') {
                    continue;
                }
                //도착했으면
                if (map[cur.getRow()][cur.getCol()] == 'D') {
                    return level;
                }
                //도착하지 않았으면 다음 으로
                for (int j = 0; j < 4; j++) {
                    int nr = cur.getRow() + moveR[j];
                    int nc = cur.getCol() + moveC[j];

                    // 갈 수 있는지 체크
                    if (isBieberAbleToGo(nr, nc) && !bieberVisited[nr][nc]) {
                        bq.add(new Node2(nr, nc));
                        bieberVisited[nr][nc] = true;
                    }

                }
            }

            //spread Water
            int wl = wq.size();

            for (int i = 0; i < wl; i++) {
                Node2 curWater = wq.poll();
                for (int j = 0; j < 4; j++) {
                    int nextWaterRow = curWater.getRow() + moveR[j];
                    int nextWaterCol = curWater.getCol() + moveC[j];
                    if (isWaterAbleToGo(nextWaterRow, nextWaterCol) && !waterVisited[nextWaterRow][nextWaterCol]) {
                        if (map[nextWaterRow][nextWaterCol] =='D') {
                            return -1;
                        }
                        map[nextWaterRow][nextWaterCol] = '*';
                        waterVisited[nextWaterRow][nextWaterCol] = true;
                        wq.add(new Node2(nextWaterRow, nextWaterCol));
                    }
                }
            }

            level++;
        }
        return -1;
    }

    private static boolean isBieberAbleToGo(int nr, int nc) {
        if (nr >= 0 && nc >= 0 && nr < mapRowSize && nc < mapColSize && map[nr][nc] != '*' && map[nr][nc] != 'X') {
            return true;
        }
        return false;
    }



    private static boolean isWaterAbleToGo(int nr, int nc) {

        if (nr >= 0 && nc >= 0 && nr < mapRowSize && nc < mapColSize && map[nr][nc] != 'X' && map[nr][nc] != 'D') {
            return true;
        }
        return false;
    }
}
