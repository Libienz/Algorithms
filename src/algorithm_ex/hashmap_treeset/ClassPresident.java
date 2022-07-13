package algorithm_ex.hashmap_treeset;

import java.util.*;

public class ClassPresident {

    public static char getPresident(int num, String str) {
        Map<Character,Integer> candidate = new HashMap<>();
        for (char key : str.toCharArray()) {
            candidate.put(key,candidate.getOrDefault(key,0)+1);
        }
        int max = 0;
        char pres = ' ';
        for (char key : candidate.keySet()) { //모든 키에 대해서 순회 가능
            if (candidate.get(key) > max) {
                max = candidate.get(key);
                pres = key;
            }
        }
        return pres;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //학생 수
        String str = sc.next(); //투표용지 모음
        System.out.println(getPresident(num, str));
    }
}
