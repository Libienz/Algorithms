import java.util.*;

public class Q1012 {

    private static ArrayList<int[][]> cases = new ArrayList<>();
    private static boolean[][] visited;
    private static int[][] curCaseMap;
    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};
    private static int res = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();
        for (int i = 0; i < caseCount; i++) {

            int rowSize = sc.nextInt();
            int colSize = sc.nextInt();
            int[][] map = new int[rowSize][colSize];
            int cabbageCount = sc.nextInt();

            for (int j = 0; j < cabbageCount; j++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                map[r][c] = 1;
            }
            cases.add(map);
        }

        for (int[][] map : cases) {
            curCaseMap = map;
            res = 0;
            visited = new boolean[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        res++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(res);
        }
    }

    public static void dfs(int row, int col) {

        visited[row][col] = true;
        //4방향 살펴보기
        for (int i = 0; i < 4; i++) {
            int nr = row + moveR[i];
            int nc = col + moveC[i];
            //인덱스 벗어나면 다음 방향 살펴보기
            if (nr < 0 || nc < 0 || nr >= curCaseMap.length || nc >= curCaseMap[0].length) {
                continue;
            }
            //주위에 배추가 있고 방문한 적이 없다면 dfs
            if (curCaseMap[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}
