package algorithm_ex.about_string;

import java.util.ArrayList;
import java.util.Scanner;

public class InterChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        char c = sc.next().charAt(0);

        int lt, rt;

        //모든 인덱스에 대해 반복
        for (int i = 0; i < str.length; i++) {
            int cnt = 0;
            lt = i;
            rt = i;
            //그 자리에 찾는게 있다면 거리는 0
            if (str[i] == c) {
                System.out.printf("%d ", cnt);
                continue;
            }
            //그렇지 않다면 반복문 진입
            //먼저 왼쪽 오른쪽으로 한칸씩 옮겨서 찾는 문자가 있는지 확인해본다.
            //왼쪽이든 오른쪽이든 먼저 발견하면 그게 최솟값 출력하고 다음 루프로!
            while (true) {
                cnt++;
                //인덱스가 유효하다면 왼쪽으로 한칸 옮겨서 우리가 찾는 문자가 있는지 확인해본다.
                if (lt-cnt >= 0 && lt-cnt < str.length) {
                    if (str[lt-cnt] == c) {
                        System.out.printf("%d ",cnt);
                        break;
                    }
                }

                //인덱스가 유효하다면 오른쪽으로 한칸 옮겨서 우리가 찾는 문자가 있는지 확인해본다.
                if (rt + cnt >= 0 && rt + cnt < str.length) {
                    if (str[rt + cnt] == c) {
                        System.out.printf("%d ", cnt);
                        break;

                    }
                }

            }
        }

    }
}
