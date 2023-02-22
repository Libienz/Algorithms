package algorithm_ex.two_pointer;

import java.util.*;

public class MaxLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //길이가 n인 수열이 주어진다
        int c = sc.nextInt(); //수열의 원소를 바꿀 기회가 c만큼 주어짐 chance

        //수열을 배열에 담는다.
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        //최대 c번의 변경으로 1로만 구성된 가장 긴 부분수열의 길이 ml을 찾아라
        int ml = Integer.MIN_VALUE;
        //case 분류 -> 부분수열의 시작지점으로
        for (int i = 0; i < n; i++) {
            //i부터 시작하는 부분 수열에서 c번의 찬스를 써서 변경했을 때 가장 긴 부분수열의 길이는 sl
            int sl = 0;
            int chance = c;
            for (int j = i; j < n; j++) {
                if (arr.get(j) == 1) {
                    sl++;
                } else {
                    if (chance > 0) {
                        chance--;
                        sl++;
                    } else {
                        break;
                    }
                }
            }
            if (sl > ml) {
                ml = sl;
            }
        }

        System.out.println(ml);



    }
}

