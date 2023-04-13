import java.util.*;

//DFS
public class Q2667 {

    static int cnt;
    static int n;
    static int[][] map;
    static int sa = 0;
    static int ac = 0;
    static ArrayList<Integer> sizes = new ArrayList<>();

    //상하좌우 따질 때 인덱스가 유효한 지 체크하는 메서드
    public static boolean isAvailableIdx(int i, int j, int n) {
        if (i >= 0 && j >= 0 && i < n && j < n) {
            return true;
        }
        return false;
    }

    //상하좌우로 갈수있을 만큼 파고들고 백트래킹
    public static void dfs(int i, int j) {
        //다녀갔다는 것을 체크
        map[i][j] = 0;
        sa++;
        //상
        if (isAvailableIdx(i - 1, j, n) && map[i - 1][j] == 1) {
            dfs(i - 1, j);
        }
        //하
        if (isAvailableIdx(i + 1, j, n) && map[i + 1][j] == 1) {
            dfs(i + 1, j);
        }
        //좌
        if (isAvailableIdx(i, j - 1, n) && map[i][j - 1] == 1) {
            dfs(i, j - 1);
        }
        //우
        if (isAvailableIdx(i, j + 1, n) && map[i][j + 1] == 1) {
            dfs(i, j + 1);
        }


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //지도의 크기는 n by n
        map = new int[n][n];

        //지도 초기화
        for (int i = 0; i < n; i++) {
            String ns = sc.next(); //number string : 입력을 이렇게 받아서 숫자 하나씩 까야 한다.
//            System.out.println("i = " + i);
//            System.out.println("ns = " + ns);
            for (int j = 0; j < n; j++) {
//                System.out.println(sc.nextInt());
                map[i][j] = ns.charAt(j) -48;
//                System.out.print(map[i][j] + " ");
            }
        }

        ArrayList<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    //1인 지점을 찾아 DFS 시작
                    ac++;
//                    System.out.println("ac = " + ac);
                    dfs(i, j);
//                    System.out.println("sa = " + sa);
                    sizes.add(sa);
                    sa = 0;
                }
            }
        }

        System.out.println(ac);
        Collections.sort(sizes);
        for (int size : sizes) {
            System.out.println(size);
        }
    }
}
