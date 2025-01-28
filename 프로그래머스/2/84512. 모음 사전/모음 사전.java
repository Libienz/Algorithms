import java.util.*;

class Solution {
    private static final String[] VOWELS = {"A", "E" , "I", "O", "U"};
    private int answer = 0;
    private int count = 0;
    public int solution(String word) {
        
        dfs("", word);
        return answer;
    }
    
    public void dfs(String cur, String word) {
        if (Objects.equals(cur, word)) {
            answer = count;
            return;
        }
        
        for (int i = 0; i < VOWELS.length; i++) {
            if (cur.length() < 5) {
                count++;
                dfs(cur + VOWELS[i], word);
            }
            cur = cur.substring(0, cur.length());
        }
    }
}