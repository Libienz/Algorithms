package algorithm_ex.about_string;

import java.util.*;

public class RepeatedDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] str = s.toCharArray();

        // 방법 1
        // Set.Contains를 이용
        // Set에 들어있는 캐릭터는 이미한번 사용되었다는 뜻
        Set<Character> charSet = new HashSet<>();
        for (char c : str) {
            //set에 들어있다면 패스
            if (charSet.contains(Character.valueOf(c))) {
                continue;
            }
            //set에 들어있지 않으면 char하나 출력
            //System.out.printf("%c", c);
            charSet.add(c);

        }
        // 방법 2
        for (int i = 0; i < str.length; i++) {
            //현재 보고 있는 인덱스와 indexOf를 이용하여 확인한 인덱스가 같다면 처음 나온 것
            //다르다면 처음 나온 것이 아님
            if (i == s.indexOf(s.charAt(i))) {
                System.out.printf("%c", s.charAt(i));
            }
        }



    }
}
