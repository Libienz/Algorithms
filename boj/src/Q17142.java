import java.util.*;
class Node {
    private int row;
    private int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

public class Q17142 {

    private static int[][] map;
    private static ArrayList<Node> virusCoords;
    private static int mapSize;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};
    private static int minimumSpreadTime = Integer.MAX_VALUE;
    private static boolean allSpread = false;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        mapSize = sc.nextInt();
        int activeCount = sc.nextInt();
        virusCoords = new ArrayList<>();
        map = new int[mapSize][mapSize];

        //연구소 지도 초기화
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = sc.nextInt();
                //바이러스의 좌표는 배열에 모아놓는다.
                if (map[i][j] == 2) {
                    virusCoords.add(new Node(i, j));
                }
            }
        }

        //바이러스의 좌표들 중 activeCount개를 활성화 시킬 때 어떤 위치에 바이러스를 활성화 시키는 것이 spreadTime이 최소가 되는가
        dfsCombination(activeCount, 0, new ArrayList<>());

        if (allSpread) {
            System.out.println(minimumSpreadTime);
        } else {
            System.out.println(-1);
        }


    }

    //바이러스 위치 중에서 m개를 뽑는 모든 경우의 수 체크
    public static void dfsCombination(int left, int idx, ArrayList<Node> selected) {

        if (left == 0) {
            //바이러스를 selected 처럼 골라서 활성화 시켰을 때 SpreadTime을 count
            int spreadTime = countSpreadTime(selected);
            //모든 칸에 퍼지는데 실패
            if (spreadTime == -1) {

            } else {
                allSpread = true;
                if (spreadTime < minimumSpreadTime) {
                    minimumSpreadTime = spreadTime;
                }
            }

        } else {
            for (int i = idx; i < virusCoords.size(); i++) {
                Node cur = virusCoords.get(i);
                //현재 보고 있는 바이러스를 활성화 시킨다.
                selected.add(cur);
                dfsCombination(left - 1, i + 1, selected);
                //현재 보고 있는 바이러스를 활성화 시키지 않는다.
                selected.remove(cur);
            }
        }
    }

    public static int countSpreadTime(ArrayList<Node> selected) {

        //bfs 요소 초기화
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[mapSize][mapSize];
        int time = 0;

        //지도 깊은 복사
        int[][] tmpMap = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
        //활성화된 바이러스 큐에 셋팅
        for (Node n : selected) {
            tmpMap[n.getRow()][n.getCol()] = 3; //활성화된 바이러스: 3으로 표현
            q.add(n);
        }

        while (!q.isEmpty()) {

            //모든 칸에 바이러스가 퍼졌는지 체크
            boolean allSpread = isAllSpread(tmpMap);
            if (allSpread) {
                return time;
            }

            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                int curRow = cur.getRow();
                int curCol = cur.getCol();

                //4방향 확인
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + moveR[j];
                    int nextCol = curCol + moveC[j];

                    //유효 인덱스 검증
                    if (!(nextRow >= 0 && nextCol >= 0 && nextRow < mapSize && nextCol < mapSize)) continue;
                    //방문 여부 확인
                    if (visited[nextRow][nextCol]) continue;

                    if (tmpMap[nextRow][nextCol] == 0 || tmpMap[nextRow][nextCol] == 2) {
                        tmpMap[nextRow][nextCol] = 3;
                        visited[nextRow][nextCol] = true;
                        q.add(new Node(nextRow, nextCol));
                    }

                }

            }
            time++;
        }

        if (isAllSpread(tmpMap)) {
            return time;
        }
        return -1;
    }

    private static boolean isAllSpread(int[][] tmpMap) {
        boolean allSpread = true;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (tmpMap[i][j] == 0) {
                    allSpread = false;
                }
            }
        }
        return allSpread;
    }
}
