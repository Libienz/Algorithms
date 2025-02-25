import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        Arrays.sort(money);
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for (int coin : money) {
            for (int i = 0; i < n + 1; i++) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] += dp[i - coin];
            }   
        }
        
        return dp[n];
    }
}