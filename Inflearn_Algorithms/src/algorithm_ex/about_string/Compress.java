package algorithm_ex.about_string;

import java.util.Scanner;

public class Compress {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char prev = str.charAt(0); //이전 문자
        String res = ""; //결과 담을 문자열
        res += prev; //첫번째 문자는 그냥 담긴다.
        int cnt = 1; //현재 인덱스까지  연속된 문자의 개수

        for (int i = 1; i < str.length(); i++) {
            //이전 문자와 현재 문자가 같다면 cnt++
            if (str.charAt(i) == prev) {
                cnt++;
            }
            //같지 않다면 cnt가 1인지 그보다 큰지 확인하고 분기
            else {
                //cnt가 1이 아니라면 결과에 덧붙여야 함
                if (cnt != 1) {
                    res += cnt;
                }
                //현재 다른 문자가 나온 상태임
                //다른 문자 res에 붙여주고 prev를 현재 문자로 바꾸고 cnt를 1로 다시 설정
                res += str.charAt(i);
                prev = str.charAt(i);
                cnt = 1;
            }
        }

        //마지막에도 한번 더 확인
        if (cnt != 1) {
            res += cnt;
        }
        System.out.println(res);

    }
}
