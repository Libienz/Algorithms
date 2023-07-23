import java.util.*;



public class Q17090RS {

    private static int n, m;
    private static char[][] map;
    private static int[][] dp;
    private static int escapeCount = 0;


    public static void main(String[] args) {

        //요소들 초기화
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // map row size
        m = sc.nextInt(); // map col size
        map = new char[n][m];
        dp = new int[n][m]; //0: non visited, 1: visited and escapable, -1: visited but no escapable

        //미로 초기화
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        //i,j에서 시작하여 미로에 적힌대로 움직일 때 탈출 할 수 있는지 확인한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //이전에 결과를 밝힌 위치인지 check

                //i, j에서 미로 출발
                dfs(i, j);

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == 1) {
                    escapeCount++;
                }

            }
        }

        System.out.println(escapeCount);

    }

    //정해진 대로만 이동해야 함. 만약 이동했는데 왔던 곳으로 왔으면 루프에 빠져 탈출할 수 없는 상태임을 알리는 것
    public static int dfs(int sr, int sc) {

        //현재 탈출했다면 return 1
        if (sr < 0 || sc < 0 || sr >= n || sc >= m) {
//            dp[sr][sc] = 1;
            return 1;
        }
        //현재 위치에 방문한 적이 있다면
        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }

        dp[sr][sc] = -1;
        char cur = map[sr][sc];
        int nr = 0, nc = 0;

        //현재 밟고 있는 곳에 적힌대로 이동
        switch (cur) {
            case 'U':
                nr = sr - 1;
                nc = sc;
                break;
            case 'D':
                nr = sr + 1;
                nc = sc;
                break;
            case 'L':
                nr = sr;
                nc = sc - 1;
                break;
            case 'R':
                nr = sr;
                nc = sc + 1;
                break;

        }


        //다음 위치에 방문한 적이 없다면
        dp[sr][sc] = dfs(nr, nc);

        return dp[sr][sc];
    }
}


