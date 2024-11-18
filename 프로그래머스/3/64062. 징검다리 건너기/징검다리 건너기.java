import java.util.*;

class Solution {
    
    public int solution(int[] stones, int k) {
        
        int left = 0;
        int right = 200000000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (check(stones, mid, k)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean check(int[] stones, int successCount, int k) {
        int jumpHop = 0;
        for (int stone : stones) {
            if (stone < successCount) {
                jumpHop++;
            } else {
                jumpHop = 0;
            }
            
            if(jumpHop >= k) {
                return false;
            }
        }
        
        return true;
    }
}