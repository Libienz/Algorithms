import java.util.*;

class Solution {
    int answer = Integer.MIN_VALUE;
    
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length+1];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j-1 < 0) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                    continue;
                }
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        
        for (int number : dp[triangle.length-1]) {
            answer = Math.max(answer, number);
        }
        return answer;
    }
    
}