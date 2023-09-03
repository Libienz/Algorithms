import java.util.*;
import java.io.*;

public class Q15684re {

    private static int N;
    private static int M;
    private static int H;
    private static boolean solved;
    private static int[][] map;
    private static ArrayList<Node> candidateNodes;
    private static ArrayList<ArrayList<Node>> deploys;


    public static void main(String[] args) throws IOException{

        //요소들 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N];
        candidateNodes = new ArrayList<>();
        deploys = new ArrayList<>();

        //가로선 세팅
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a - 1][b - 1] = 1; //1은 오른쪽으로 연결된 사다리가 있다는 뜻
            map[a - 1][b] = -1; //-1은 왼쪽으로 연결된 사다리가 있다는 뜻
        }

        //사다리 추가 없이 모두 자기 넘버로 회귀하면 0출력 후 끝
        if (allReturnsToItsNumber(map)) {
            bw.write("0");
            bw.flush();
            return;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N -1; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    candidateNodes.add(new Node(i, j));
                }
            }
        }
        //추가 사다리가 필요한 경우
        for (int i = 1; i <= 3; i++) {
            //i개의 사다리를 추가로 두어 해결할 수 있는지 확인
            deploys.clear();
//            System.out.println("====" + i + "====");
            //candidateNodes에서 2개를 뽑는 경우를 dfs로 모두 구한다.
            dfsCombination(i, 0, new ArrayList<>());
            if (solved) {
                break;
            }
        }
        if (!solved) {
            System.out.println(-1);
        }
//        bw.write("-1");
//        bw.flush();

    }

    public static boolean allReturnsToItsNumber(int[][] newMap) {

        for (int i = 0; i < N; i++) {
            //i번 세로선에서 출발했을 때 i번으로 돌아왔는가?
            int en = driveLadder(i, newMap);
            if (en != i) {
                return false;
            }
        }
        return true;
    }

    public static int driveLadder(int sn, int[][] map) {
        int r = 0;
        int c = sn;
//        System.out.println("r = " + r);
//        System.out.println("c = " + c);
        boolean prevSideMoved = false;
        while (r < H) {

            if (map[r][c] == 0) {
                r++;
                c = c;
                prevSideMoved = false;
            } else {
                if (prevSideMoved) {
                    r++;
                    c = c;
                    prevSideMoved = false;
                } else if (map[r][c] == -1) {
                    prevSideMoved = true;
                    r = r;
                    c = c - 1;
                } else if (map[r][c] == 1) {
                    prevSideMoved = true;
                    r = r;
                    c = c + 1;
                }
            }
        }
        return c;
    }

    public static void dfsCombination(int leftChoice, int idx, ArrayList<Node> choicedNodes) {

        if (leftChoice == 0) {

            int[][] addedMap = isDeployConsistence(choicedNodes);
            if (addedMap == null) {
                return;
            }
            if (allReturnsToItsNumber(addedMap)) {
                System.out.println(choicedNodes.size());
                solved = true;
                return;
            }
        } else {
            for (int i = idx; i < candidateNodes.size(); i++) {
                Node cur = candidateNodes.get(i);
                //cur를 선택한다.
                choicedNodes.add(cur);
                //shortcut propagate
                if (solved) {
                    return;
                }
                dfsCombination(leftChoice-1, i + 1, choicedNodes);
                //cur를 선택하지 않는다.
                choicedNodes.remove(cur);
            }
        }
    }

    public static int[][] isDeployConsistence(ArrayList<Node> choicedNodes) {
//        System.out.println("choicedNodes = " + choicedNodes);
        //tmpMap으로 복사
        int[][] tmpMap = new int[H][N];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }

        for (Node choicedNode : choicedNodes) {
            //양 끝부분에 사다리 놓을 경우 별도 처리
            if (choicedNode.c + 1 == N) {
                return null;
            }
            tmpMap[choicedNode.r][choicedNode.c] = 1;
            tmpMap[choicedNode.r][choicedNode.c + 1] = -1;
        }


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N - 2; j++) {
                if (tmpMap[i][j] != 0 && tmpMap[i][j] == tmpMap[i][j+1]) {
                    return null;
                }
            }
        }
        return tmpMap;
    }

    static class Node {
        private int r;
        private int c;

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
}
