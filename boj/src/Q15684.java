import java.util.*;

//개 빡구현 문제 처럼 느껴지네 ..
public class Q15684 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //세로선의 개수
        int m = sc.nextInt(); //가로선의 개수
        int h = sc.nextInt(); //세로선마다 가로선을 놓을 수 있는 위치의 개수 h

        //2차원 배열로 사다리 표현 가로선의 표시를 위해 열을 2배로
        int[][] map = new int[h][2*n + 1];

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
        //map 출력해보기
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println();

    }
}
