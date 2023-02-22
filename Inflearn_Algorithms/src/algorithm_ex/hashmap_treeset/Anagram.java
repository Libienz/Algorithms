package algorithm_ex.hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        if (isAnagram(s1, s2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static boolean isAnagram(String s1, String s2) {

        Map<Character, Integer> map = new HashMap<>();

        //s1의 구성 정보를 map에 담는다.
        char[] s1arr = s1.toCharArray();
        for (char c : s1arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //s2의 구성 정보를 map과 대조한다. -> s2의 정보를 map에서 빼서 후에 map의 모든 key에 대한 val이 0인지 확인
        char[] s2arr = s2.toCharArray();
        for (char c : s2arr) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        Set<Character> set = map.keySet();
        for (Character c : set) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;

    }
}
