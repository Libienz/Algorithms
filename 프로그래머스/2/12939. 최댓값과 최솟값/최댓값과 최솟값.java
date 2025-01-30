import java.util.*;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(s);
        for (String number : s.split(" ")) {
            int cur = Integer.parseInt(number);
            
            if (cur < min) {
                min = cur;
            }
            if (cur > max) {
                max = cur;
            }
        }
        return min + " " + max;
        
    }
}