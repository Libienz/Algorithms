import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        Map<String, Integer> gemCount = new HashMap<>();
        
        for (int i = 0; i < gems.length; i++) {
            gemSet.add(gems[i]);
        }
        
        int typeCount = gemSet.size();
        
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while (right < gems.length && left <= right) { 
            String cur = gems[right];
            gemCount.put(cur, gemCount.getOrDefault(cur, 0) + 1);
            while (gemCount.keySet().size() == typeCount) {
                gemCount.put(gems[left], gemCount.get(gems[left]) - 1);
                if (gemCount.get(gems[left]) == 0) {
                    gemCount.remove(gems[left]);
                }               
                if (right - left <  minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;   
                }
                left++;
            } 
            if (gemCount.keySet().size() < typeCount) {
                right++;
            }
        }
        

        return answer; 
    }
}