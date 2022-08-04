package recursive;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;




public class FindCow2 {


    public static int countJump(int person, int cow) {

        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[10001];
        visited [person] = true;
        int[] move = new int[3];
        int level = 0;
        move[0] = -1;
        move[1] = 1;
        move[2] = 5;
        Q.add(person);

        while(!Q.isEmpty()) {

            int len = Q.size();
            for (int i = 0; i<len; i++) { //현재 레벨에 속한 애들을 모두 둘러 볼 예정

                int cur = Q.poll();
                //System.out.println("cur = " + cur);

                if (cur == cow) {
                    return level;
                }
                for (int mv : move) { //여기에서 갈 수 있는 애들을 Q에 추가하는 코드

                    if (cur + mv < 0 || cur + mv > 10000) {
                        continue;
                    }

                    if (visited[cur + mv]) { //새로 구한 자식이 방문한 적이 있음
                        continue;
                    }
                    else {

                        Q.add(cur + mv);
                        visited[cur + mv] = true;
                    }
                }
            }
            level++;
        }

        return -111;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int person = sc.nextInt();
        int cow = sc.nextInt();

        System.out.println(countJump(person, cow));
    }
}
