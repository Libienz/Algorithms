import java.lang.reflect.Array;
import java.util.*;

public class Q15684 {

    static int n;
    static int m;
    static int h;
    static int[][] map;
    static boolean solvable;

    //모든 세로선이 자기자신으로 떨어지는 지 확인
    public static boolean isAllColumnReturnToItsNumber() {

        for (int i = 0; i < n; i++) {
            //i번째 세로선이 i번으로 떨어지는 지 확인
            int curR = 0;
            int curC = i;
            for (int j = 0; j < h; j++) {
                if (map[curR][curC] == 1) { //map의 값이 1이라면 오른쪽으로 연결된 사다리가 있는 것
                    curR = curR + 1;
                    curC = curC + 1;
                } else if (map[curR][curC] == -1) { //map의 값이 -1이라면 왼쪽으로 연결된 사다리가 있는 것
                    curR = curR + 1;
                    curC = curC - 1;
                } else { //가로 사다리가 없으면 그대로 아래로
                    curR = curR + 1;
                }
            }
            //i번 세로선의 종착지가 i번 세로 라인인지 확인
            if (curC != i) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int left, int rInd, int cInd) {
        //정해진 개수만큼 추가할 사다리를 모두 고른 상태
        if (left == 0) {
            //고른 상태가 정답이 되었을 때
            if (isAllColumnReturnToItsNumber()) {
                solvable = true;
            }
            return;
        } else {
            //가로선 고르기
            //2차원 인덱스를 기억하고 있기에 보고 있던 열의 나머지 부분을 추가적으로 체크
            for (int j = cInd; j < n - 1; j++) {
                if (map[rInd][j] == 0 && map[rInd][j + 1] == 0) {
                    map[rInd][j] = 1;
                    map[rInd][j + 1] = -1;
                    //가로선 하나 선택 완료
                    dfs(left - 1,rInd,j);
                    //해당 가로선 쓰지 않음
                    map[rInd][j] = 0;
                    map[rInd][j + 1] = 0;
                }
            }
            //보고 있던 열 다봤음 다음 열부터 다시
            for (int i = rInd + 1; i < h; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == 0 && map[i][j + 1] == 0) {
                        map[i][j] = 1;
                        map[i][j + 1] = -1;
                        //가로선 하나 선택 완료
                        dfs(left - 1,i,j + 2);
                        //back tracking 해당 가로선을 선택 안한 것으로 하고 다음 가로선들 체크
                        map[i][j] = 0;
                        map[i][j + 1] = 0;

                    }
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //세로선의 개수
        m = sc.nextInt(); //가로선의 개수
        h = sc.nextInt(); //가로선을 놓을 수 있는 위치의 개수

        map = new int[h][n];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a-1][b-1] = 1;
            map[a-1][b] = -1;

        }

//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[1].length; j++) {
//                System.out.printf("%-5d",map[i][j]);
//            }
//            System.out.println();
//        }

        for (int i = 0; i <= 3; i++) {
            solvable = false;
            dfs(i, 0, 0);
            if (solvable) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);



    }

}
