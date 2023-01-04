package algorithm_ex.hashmap_treeset;

import java.util.*;

public class ClassPresident {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        char res =' ';
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();
        String voted = sc.next();
        char[] votes = voted.toCharArray();
        //System.out.println(voted);
        for (int i = 0; i < size; i++) {
            map.put(votes[i], map.getOrDefault(votes[i],0)+1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) > max) {
                res = c;
                max = map.get(c);
            }
        }
        System.out.println(res);


    }

}
