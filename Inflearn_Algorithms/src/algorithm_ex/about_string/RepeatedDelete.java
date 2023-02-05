package algorithm_ex.about_string;

import java.util.*;

public class RepeatedDelete {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();

        String res = "";
        //원래 순서를 유지해야 함으로 set은 사용 할때 추가적인 조치 필요 -> set은 순서를 따지지 않는다.
        ArrayList<Character> arr = new ArrayList<>();
        for (char c : chars) {
            if (arr.contains(c)) {
                continue;
            }
            arr.add(c);
            res += c;
        }

        System.out.println(res);
    }
}
