package algorithm_ex.hashmap_treeset;

import java.util.*;

public class ClassPresident {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String p = sc.next();

        char[] pa = p.toCharArray();

        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = pa[i];
            m.put(c, (m.getOrDefault(c, 0) + 1));
        }

        Set<Character> set = m.keySet();
        char vc = 0;
        int cn = Integer.MIN_VALUE;
        for (Character c : set) {
            Integer n = m.get(c);
            if (n > cn) {
                vc = c;
                cn = n;
            }
        }
        System.out.println(vc);
    }
}
