import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int left = 0;
        int right = 0;
        int[] result = {0, 1000000};
        int sum = 0;
    
        while (left <= right && right < sequence.length) {
            sum += sequence[right];
            while (sum > k && left <= right) {
                sum -= sequence[left++];
            }
            
            if (sum == k) {
                int curLength = right - left;
                int resultLength = result[1] - result[0];
                if (curLength < resultLength) {
                    result[0] = left;
                    result[1] = right;  
                }
            }
            right++;
        }
        
        return result;
    }
}