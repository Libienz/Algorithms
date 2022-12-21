package algorithm_ex.about_string;

import java.util.*;

/*
소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 */
public class RepeatedDelete {
    public static String deleteRepeated(String str) {
        char[] ch_arr = str.toCharArray();
        //ArrayList<Character> ans = new ArrayList<Character>();
        String ans = "";
        for (int i=0; i< ch_arr.length; i++) {
            if(ans.indexOf(ch_arr[i]) == -1) {
                ans += (ch_arr[i]);
            }
        }
        return ans;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(RepeatedDelete.deleteRepeated(str));
    }
}
