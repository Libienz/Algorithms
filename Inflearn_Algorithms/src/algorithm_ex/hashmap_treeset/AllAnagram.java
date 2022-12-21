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

    public static boolean isSameMap(Map<Character,Integer> map, Map<Character,Integer> obj_map) {
        /*for (char key : obj_map.keySet()) {
            if (!map.containsKey(key)) return false;
            if (map.get(key) != obj_map.get(key)) return false;
        }
        return true;*/
        return map.equals(obj_map);
    }

    public static int findAllAnagram(String str1, String str2) {

        Map<Character,Integer> obj_map = new HashMap<>();
        Map<Character,Integer> map = new HashMap<>();


        int count = 0;
        //목적 맵 설정
        char[] str1_arr = str1.toCharArray();
        for (char key : str2.toCharArray()) {
            obj_map.put(key,obj_map.getOrDefault(key,0) + 1);
        }

        //첫번째 슬라이드
        for (int i = 0; i < str2.length(); i++) {
            map.put(str1_arr[i],map.getOrDefault(str1_arr[i],0) + 1);
        }
        if (isSameMap(map,obj_map)) count++;

        for (int i = 1; i <= str1_arr.length-str2.length(); i++) {
            int lt = i - 1;
            int rt = lt + str2.length();
            map.put(str1_arr[lt], map.get(str1_arr[lt])-1); // 빼야할 것 빼고
            if (map.get(str1_arr[lt]) == 0) {
                map.remove(str1_arr[lt]);
            }
            map.put(str1_arr[rt], map.getOrDefault(str1_arr[rt],0)+1); //더해야할 것 더하면 새로운 슬라이드에 대한 맵 완성

            if (isSameMap(map,obj_map)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(findAllAnagram(str1, str2));

    }
}
