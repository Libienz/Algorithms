package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Problem {
    int solTime;
    int score;
    public Problem(int solTime, int score) {
        this.solTime = solTime;
        this.score = score;
    }
}
public class MaxScore {

    static int n, m;
    static ArrayList<Problem> pbs;
    static int totalTime;
    static int totalScore;
    static int maxScore = Integer.MIN_VALUE;
    public static void dfs(int idx) {
        //끝까지 돌았음
        if (idx >= n) {
            //총 시간이 주어진 제한시간을 넘지 않았을 때
            if (totalTime <= m) {
                //지금까지 계산한 최대 점수와 비교
                if (maxScore < totalScore) {
                    maxScore = totalScore;
                }
            }

        } else {
            //푼다.
            Problem cur = pbs.get(idx);
            totalTime += cur.solTime;
            totalScore += cur.score;
            dfs(idx + 1);
            //풀지 않는다.
            totalTime -= cur.solTime;
            totalScore -= cur.score;
            dfs(idx + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //문제 개수
        m = sc.nextInt(); //제한 시간

        pbs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int solTime = sc.nextInt();
            pbs.add(new Problem(solTime, score));
        }

        dfs(0);
        System.out.println(maxScore);

    }
}
