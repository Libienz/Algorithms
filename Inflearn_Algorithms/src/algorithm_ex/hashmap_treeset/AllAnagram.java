package algorithm_ex.hashmap_treeset;

import java.util.*;

public class AllAnagram {

    public static boolean isAnagram(String s, String t) {

//        System.out.println("s = " + s);
//        System.out.println("t = " + t);
        Map<Character, Integer> map = new HashMap<>();

        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        for (char c : sa) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ta) {
            map.put(c, map.getOrDefault(c,0) -1);
        }

        Set<Character> cs = map.keySet();
        for (char c : cs) {
            if (map.get(c) != 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        //System.out.println("s = " + s);
        //System.out.println("t = " + t);

        int si = 0; //start idx
        int ei = t.length()-1; //end idx
        int cnt = 0;

        //시작하는 부분을 case 분류의 기준으로 처음부터 연속 부분 문자열을 모두 아나그램인지 따진다.
        for (int i = 0; i < s.length(); i++) {
            si = i;
            ei = si + t.length() - 1;
            if (ei > s.length() -1 ){
                break;
            }
            String substring = s.substring(si, ei + 1);

            if (isAnagram(substring, t)) {
                cnt++;
            }
        }

        System.out.println(cnt);
        //처음부터 옮겨가며 아나그램인지 체크


    }

}