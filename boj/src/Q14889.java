import java.util.*;

public class Q14889 {

    static int n;
    static ArrayList<Integer> team1;
    static ArrayList<Integer> team2;
    static int[][] ab;
    static int minDiff = Integer.MAX_VALUE;
    static ArrayList<Integer> permutation;
    static boolean[] used;
    static int ta;


    public static int getTeamAbility(ArrayList<Integer> team) {
        int ability = 0;
        //팀에서 임의 두명을 뽑았을 때의 능력치를 더해나가고 리턴한다.
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                if (i == j) {
                    continue;
                }
                ability += ab[team.get(i)][team.get(j)];
            }
        }
        return ability;
    }

    public static void combinationDfs(int ch, int idx) {
        if (ch == n / 2) {
            //팀고르기 끝 team1에는 선수들이 편성되어있음
            //team1에 편성되지 못한 선수들은 team2로!
            for (int i = 0; i < n; i++) {
                if (!team1.contains(i)) {
                    team2.add(i);
                }
            }
            //각팀의 능력치를 구한다.
            int team1Ability = getTeamAbility(team1);
            int team2Ability = getTeamAbility(team2);

            //능력치의 차를 계산한다.
            int diff = Math.abs(team1Ability - team2Ability);

            //능력치의 차가 최소인지 확인한다.
            if (diff < minDiff) {
                minDiff = diff;
            }
            team2.clear();
        } else {
            for (int i = idx; i < n; i++) {
                //i번 선수를 team1에 포함한다
                team1.add(i);
                combinationDfs(ch + 1, i + 1);
                used[i] = true;
                //i번 선수를 team1에 포함하지 않는다
                team1.remove((Object) i);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //n명의 사람들이 축구를 한다.
        team1 = new ArrayList<>();
        team2 = new ArrayList<>();
        ab = new int[n][n]; //ab[i][j] + ab[j][i]는 i와 j가 같은 팀에 속했을 때 해당팀에 더해지는 능력치이다.
        used = new boolean[n];
        permutation = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i][j] = sc.nextInt();
            }
        }
        //1. 조합을 이용 두 팀으로 나눈다. static 변수인 team1과 team2에 나눠진
        combinationDfs(0, 0);
        System.out.println(minDiff);

    }
}
