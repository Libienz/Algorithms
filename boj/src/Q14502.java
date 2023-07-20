import java.util.*;

public class Q14502 {

    private static int mapHeight;
    private static int mapWidth;
    private static int[][] map;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};
    private static int maxSafeArea = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        mapHeight = sc.nextInt();
        mapWidth = sc.nextInt();
        map = new int[mapHeight][mapWidth];

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //벽을 SPARE_WALL_COUNT개 세웠을 때 가장 큰 안전영역이 나오도록 벽을 세워야 함
        //그 때 안전 영역으 크기를 출력하는 문제
        //sol> 벽을 세울 위치의 모든 경우 따진다

        for (int i = 0; i < mapHeight * mapWidth; i++) {
            for (int j = i + 1; j < mapHeight * mapWidth; j++) {
                for (int k = j + 1; k < mapHeight * mapWidth; k++) {
                    int row, col;
                    //새로운 벽 1의 좌표
                    int r1 = i / mapWidth;
                    int c1 = i % mapWidth;
                    //새로운 벽 2의 좌표
                    int r2 = j / mapWidth;
                    int c2 = j % mapWidth;
                    //새로운 벽 3의 좌표
                    int r3 = k / mapWidth;
                    int c3 = k % mapWidth;

                    //새로운 벽 3개의 위치가 벽을 세울 수 있는 위치일 때 따진다.
                    if (map[r1][c1] == 0
                            && map[r2][c2] == 0
                            && map[r3][c3] == 0) {
                        //3개의 벽의 위치를 파라미터와 같이 정했을 때 안전 영역의 크기를 구하라
                        int count = countSafeArea(r1, c1, r2, c2, r3, c3);
                        if (count > maxSafeArea) {
                            maxSafeArea = count;
                        }
                    }
                }
            }
        }
        System.out.println(maxSafeArea);

    }

    public static int countSafeArea(int r1, int c1, int r2, int c2, int r3, int c3) {
        // tmpMap: map의 깊은 복사
        int[][] tmpMap = new int[mapHeight][mapWidth];
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
        // visited 초기화
        boolean[][] visited = new boolean[mapHeight][mapWidth];

        //벽 3개 건설
        tmpMap[r1][c1] = 1;
        tmpMap[r2][c2] = 1;
        tmpMap[r3][c3] = 1;

        //감염지점으로부터 infect 영향 모두 미치게 한다.
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                if (tmpMap[i][j] == 2 && !visited[i][j]) {
                    visited[i][j] = true;
                    infect(i, j, tmpMap, visited);
                }
            }
        }

        //모든 infect가 끝난 후 안전영역 값 산출
        int safeArea = 0;
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                if (tmpMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;

    }

    public static void infect(int r, int c, int[][] tmpMap, boolean[][] visited) {

        //4방향 살펴보기
        for (int i = 0; i < moveR.length; i++) {
            int newR = r + moveR[i];
            int newC = c + moveC[i];
            //유효 인덱스 검사
            if (!(newR >= 0 && newR < mapHeight && newC >= 0 && newC < mapWidth)) {
                continue;
            }
            if (tmpMap[newR][newC] == 0 ) {
                tmpMap[newR][newC] = 2;
                visited[newR][newC] = true;
                infect(newR, newC, tmpMap, visited);
            }
        }
    }
}
