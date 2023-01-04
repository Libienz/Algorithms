package algorithm_ex.hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    1. 문자열 두개 입력받기
    2. 두번째 문자열 해쉬맵에 넣기
    3. 첫번째 문자열 각 자리의 캐릭터 순회하며 두번째 문자열 사이즈만큼의
        부분 해쉬맵과 비교
    4. 빼며 리무브브
*/
public class AllAnagram {

    public static boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char key = s1.charAt(i);
            int val = map.getOrDefault(key, 0);
            map.put(key, val + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char key = s2.charAt(i);
            int val = map.getOrDefault(key, 0);
            map.put(key, val - 1);
        }
        for (char c : map.keySet()) {
            int val = map.get(c);
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String subString = "";

        int cnt = 0;

        //첫번째 subString
        for (int i = 0; i < s2.length(); i++) {
            subString += s1.charAt(i);
        }
        if (isAnagram(subString, s2)) {
            cnt++;
        }
        //이후의 subString
        int maxIdx = s1.length();
        int startIdx = s2.length();
        for (int i = startIdx; i < maxIdx; i++) {
            subString = subString.substring(1) + s1.charAt(i);
            //System.out.println("subString = " + subString);
            if (isAnagram(subString, s2)) {
                cnt++;
            }
        }
        System.out.println(cnt);




    }
}
