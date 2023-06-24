package algorithm_ex.greedy;

import java.util.*;


public class Wrestling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n명의 지원자가 씨름선수 선발 공고에 지원했다.
        int[] ha = new int[n]; //ha[i] -> i번선수의 키
        int[] wa = new int[n]; //wa[i] -> i번선수의 몸무게
        int res = n;

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt(); //지원자의 키
            int w = sc.nextInt(); //지원자의 몸무게
            ha[i] = h;
            wa[i] = w;
        }

        for (int i = 0; i < n; i++) {
            int ch = ha[i]; //보고 있는 선수의 키
            int cw = wa[i]; //보고 있는 선수의 몸무게

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (ch < ha[j] && cw < wa[j]) { //보고 있는 선수 보다 키도 몸무게도 높은 선수가 존재하면
                    res--;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}

