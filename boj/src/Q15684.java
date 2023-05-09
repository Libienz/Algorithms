import java.lang.reflect.Array;
import java.util.*;

//개 빡구현 문제 처럼 느껴지네 ..
class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Node{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}
public class Q15684 {

    static int[][] map;
    static int n;
    static int m;
    static int h;
    static boolean prevSideMv = false;
    static ArrayList<Node> candidates;
    static ArrayList<Node> choiced;

    public static boolean isInRange(int r, int c) {
        if (0 <= r && r < map.length && c >= 0 && c < map[0].length) {
            return true;
        }
        return false;
    }
    public static void dfs(int ch, int idx, int obj) {
        //가로선 후보들 중 obj개를 뽑았다.
        if (ch == obj) {
            //뽑은 가로선들이 조건에 맞아서 병행가능한지 체크

            if (isAvailable(choiced)) {
                //병행 가능하다.
                //답이 될 수 있는지 체크
//                System.out.println("obj = " + obj);
//                System.out.println("choiced = " + choiced);
                for (int i = 1; i < map[0].length; i += 2) {
                    if (driveLadder(0, i)) {
                        System.out.println(obj);
                    }
                }
            }

        } else {
            for (int i = idx; i < candidates.size(); i++) {
                //i번째 가로 후보를 사용한다.
                choiced.add(candidates.get(i));
                dfs(ch+1, i + 1, obj);
                choiced.remove(candidates.get(i));
                //사용하지 않는다.
            }
        }
    }

    public static boolean isAvailable(ArrayList<Node> choiced) {
        //고른 가로선들을 반영하여 tmpMap을 만들어본다.
        int[][] tmpMap = new int[h + 2][2 * n + 1];
        for (int i = 0; i < tmpMap.length; i++) {
            for (int j = 0; j < tmpMap[0].length; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
        for (Node n : choiced) {
            tmpMap[n.r][n.c] = 1;
        }

        //tmpmap 완성
        //가로선은 연속하거나 접하면 안되는데 이를 따져보자
        for (int r = 0; r < tmpMap.length; r++) {
            //r번째 row에서 가로선이 적절하게 들어있는 지 체크
            for (int c = 0; c < tmpMap[0].length; c += 2) {
                //왼쪽과 연속되는 가로선이 있는지 체크
                if (c - 2 >= 0) {
                    int left = tmpMap[r][c - 2];
                    if (left == 1 && tmpMap[r][c] == 1) {
                        return false;
                    }
                }
                if (c + 2 < tmpMap[0].length) {
                    int right = tmpMap[r][c + 2];
                    if (right == 1 && tmpMap[r][c] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean driveLadder(int r, int c) {

        int row = r;
        int col = c;
        while (row != h + 1) {

            //왼쪽 혹은 오른쪽 먼저 살펴본다.

            //오른쪽
            row = row;
            col = col + 2;
            if (isInRange(row,col) && map[row][col] == 1 && !prevSideMv) {
                prevSideMv = true;
                continue;
            }
            //왼쪽
            row = row;
            col = col - 4;
            if (isInRange(row,col) && map[row][col] == 1 && !prevSideMv) {
                prevSideMv = true;
                continue;
            } else {
                prevSideMv = false;
                row = row + 1;
            }
        }
        if (col == c) {
            return true;
        } else {
            return false;
        }



    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //세로선의 개수
        m = sc.nextInt(); //가로선의 개수
        h = sc.nextInt(); //세로선마다 가로선을 놓을 수 있는 위치의 개수 h

        //2차원 배열로 사다리 표현 가로선의 표시를 위해 열을 2배로
        map = new int[h+2][2*n + 1];
        candidates = new ArrayList<>();
        choiced = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
                if (j % 2 == 1) {
                    map[i][j] = 1;
                }
            }
        }
        //가로선이 존재하면 가로선의 정보를 받는다.
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //b번 세로선과 b+1번 세로선을 a번 점선위치에서 연결했다는 의미
            map[a][2 * b] = 1;

        }
        //map 출력
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();
        }
        //0인부분들 중 일부는 가로선을 놓을 수 있는 곳임
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 0; j < map[0].length; j += 2) {
                if (map[i][j] == 0) {
                    candidates.add(new Node(i, j));
                }
            }
        }


        //정답은 0, 1, 2, 3중에 하나!
        for (int chance = 0; chance <= 3; chance++) {
            //가로선으로 선택 가능한 좌표들을 담고 있는 candidates 에서 chance개의 노드를 고른다.
            dfs(0, 0, chance);

        }

    }
}
