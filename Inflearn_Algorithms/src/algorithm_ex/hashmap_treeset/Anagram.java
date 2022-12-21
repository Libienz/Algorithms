package algorithm_ex.hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

    public static boolean isAnagram(String str1, String str2) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for (char key : str1.toCharArray()) {
            map1.put(key,map1.getOrDefault(key,0)+1);
        }
        for (char key : str2.toCharArray()) {
            map2.put(key,map2.getOrDefault(key,0)+1);
        }
        for (char key : map1.keySet()) {
            if (map2.containsKey(key) && (map1.get(key) == map2.get(key))) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        if (isAnagram(str1,str2)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
