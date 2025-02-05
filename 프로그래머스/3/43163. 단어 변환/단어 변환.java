import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        int level = 0;
        boolean[] visited = new boolean[words.length];
        q.add(begin);
        
        
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return level;
                }
                
                for (int j = 0; j < words.length; j++) {
                    if (isChangable(cur, words[j]) && !visited[j]) {
                        q.add(words[j]);
                        visited[j] = true;
                    }
                }
            }
            level++;
        }
        
        return 0;
    }
    
    public boolean isChangable(String begin, String target) {
        char[] bca = begin.toCharArray();
        char[] tca = target.toCharArray();
        
        int diffCount = 0;
        for (int i = 0; i < bca.length; i++) {
            if (bca[i] != tca[i]) {
                diffCount++;
            }
        }
        
        return diffCount <= 1;
    }
}