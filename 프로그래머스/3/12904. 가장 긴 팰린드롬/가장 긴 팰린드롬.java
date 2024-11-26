import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // baababc
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxPalindromeLength = Integer.MIN_VALUE;
        
        for (int i = 0; i<s.length(); i++) {
            int palindromeLength = 1;
            int left = i - 1;
            int right = i + 1;
            while (true) {
                if (left < 0 || left >= s.length() || right < 0 || right >= s.length()) {
                    maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLength);
                    break;
                }
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    palindromeLength+=2;    
                    maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLength);
                } else {
                    break;
                }
                
            }
            
            if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
                palindromeLength = 2;
                left = i - 2;
                right = i + 1;
                while (true) {
                    if (left < 0 || left >= s.length() || right < 0 || right >= s.length()) {
                        maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLength);
                        break;
                    }
                    if (s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                        palindromeLength+=2;    
                        maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLength);
                    } else {
                        break;
                    }
                }
            }
                
        }
        
        return maxPalindromeLength;
    }
    
    public boolean isPalindrome(String target) {
        for (int i = 0; i<target.length(); i++) {
            if (target.charAt(i) != target.charAt(target.length()-i)) {
                return false;
            }
        }
        return true;
    }
}