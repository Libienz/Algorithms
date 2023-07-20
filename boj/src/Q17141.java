import java.util.*;

public class Q17141 {

    private static int[][] map;
    private static int mapSize;
    private static int virusCount;
    private static ArrayList<int[][]> virusDropCaseMaps;
    private static int minimumSpreadTime = Integer.MAX_VALUE;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        mapSize = sc.nextInt();
        virusCount = sc.nextInt();

        //연구소 지도 초기화
        map = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //승원이는 지도의 값이 2인지점에 바이러스를 둘 수 있다. (virusCount개)
        //dfs를 통해 승원이가 바이러스를 배치하는 모든 경우의 수를 구한다.
        //승원이가 바이러스를 배치한 경우의 수마다 temp 지도를 그리도록 하고 해당 지도를 virusDropCaseMaps에 모아놓는다.
        virusDropCaseMaps = new ArrayList<>();
        combinationDFS(virusCount, 0, 0, new ArrayList<>());

        //dfs가 끝난 시점 모든 배치 지도들이 virusDropCaseMaps에 있는 상태임
        boolean solved = false;
        for (int[][] caseMap : virusDropCaseMaps) {
            // caseMap과 같이 바이러스를 배치했을 때 spreadTime을 구한다.
            int time = countSpreadTime(caseMap);
            //최솟값이면 갱신하고 다음 배치를 따진다.
            if (time < minimumSpreadTime && time != -1) {
                solved = true;
                minimumSpreadTime = time;
            }
        }
        if (solved) {
            System.out.println(minimumSpreadTime);
        } else {
            System.out.println(-1);

        }
    }

    public static void combinationDFS(int left, int r, int c, ArrayList<Integer> virusPutIdxs) {

        //모든 바이러스를 배치한 경우
        if (left == 0) {
            //지도 깊은 복사
            int[][] tmpMap = new int[mapSize][mapSize];
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    tmpMap[i][j] = map[i][j];
                    if (map[i][j] == 2) {
                        tmpMap[i][j] = 0;
                    }
                }
            }
            //지정한 위치에 바이러스 배치
            for (int i = 0; i < virusPutIdxs.size() / 2; i++) {
                Integer vr = virusPutIdxs.get(i * 2);
                Integer vc = virusPutIdxs.get(i * 2 + 1);
                tmpMap[vr][vc] = 2;
            }
            //해당 경우의 지도 추가
            virusDropCaseMaps.add(tmpMap);

        } else {
            if (r == mapSize) {
                return;
            }
            //해당 열의 나머지 부분 체크
            //조합 진행 인덱스의 r과 c중 r열의 c+1부터 나머지 확인하는 것
            for (int j = c; j < mapSize; j++) {
                int nextC = (j + 1) % mapSize;
                int nextR = r;
                if (nextC == 0) {
                    nextR += 1;
                }

                if (map[r][j] == 2) {
                    //바이러스를 현재 위치에 투하
                    virusPutIdxs.add(r);
                    virusPutIdxs.add(j);
                    combinationDFS(left-1, nextR, nextC, virusPutIdxs);

                    //바이러스를 현재 위치에 투하하지 않는다.
                    virusPutIdxs.remove(virusPutIdxs.size() - 1);
                    virusPutIdxs.remove(virusPutIdxs.size() - 1);
                    //다음 루프로
                }
            }
            //다음 열부터 진행
            for (int i = r+1; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {

                    int nextC = (j + 1) % mapSize;
                    int nextR = i;
                    if (nextC == 0) {
                        nextR += 1;
                    }

                    if (map[i][j] == 2) {
                        //바이러스를 현재 위치에 투하
                        virusPutIdxs.add(i);
                        virusPutIdxs.add(j);

                        combinationDFS(left-1, nextR, nextC, virusPutIdxs);
                        //바이러스를 현재 위치에 투하하지 않는다.
                        virusPutIdxs.remove(virusPutIdxs.size() - 1);
                        virusPutIdxs.remove(virusPutIdxs.size() - 1);
                        //다음 루프로
                    }
                }
            }
        }

    }

    public static int countSpreadTime(int[][] caseMap) {

        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[mapSize][mapSize];
        int time = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (caseMap[i][j] == 2) {
                    q.add(i);
                    q.add(j);
                }
            }
        }

        while (!q.isEmpty()) {
            int len = q.size() / 2;
            boolean spread = false;
            for (int i = 0; i < len; i++) {
                Integer curR = q.poll();
                Integer curC = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nextR = curR + moveR[j];
                    int nextC = curC + moveC[j];
                    //인덱스 유효 검사
                    if (!(nextR >= 0 && nextR < mapSize && nextC >= 0 && nextC < mapSize)) {
                        continue;
                    }
                    if (caseMap[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                        spread = true;
                        caseMap[nextR][nextC] = 2;
                        q.add(nextR);
                        q.add(nextC);
                        visited[nextR][nextC] = true;
                    }
                }
            }
            if (spread) {
                time++;
            }
        }
        // 모든 빈 칸을 바이러스로 채웠는지 체크
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (caseMap[i][j] == 0) {
                    return -1;
                }
            }
        }
        return time;

    }
}
