import java.util.*;

class Solution {
    private static Set<Set<String>> answers = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        List<List<String>> matches = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();
        
        for (int i = 0; i < banned_id.length; i++) {
            matches.add(new ArrayList<>());
            String banPattern = banned_id[i];
            for (String userId : user_id) {
                if (matches(banPattern, userId)) {
                    matches.get(i).add(userId);
                }
            }
        }
        
        Set<String> used = new HashSet<>();
        
        dfs(0, banned_id, matches, used);
        return answers.size();
    }
    
    public boolean matches(String pattern, String target) {
        char[] pa = pattern.toCharArray();
        char[] ta = target.toCharArray();
        if (pa.length != ta.length) {
            return false;
        }
        for (int i = 0; i < pa.length; i++) {
            char pc = pa[i];
            char tc = ta[i];
            if (pc == '*') {
                continue;
            }
            if (pc != tc) {
                return false;
            }
        }
        
        return true;
    }
    
    public void dfs(int index, String[] patterns, List<List<String>> matches, Set<String> used) {
        if (index >= matches.size()) {
            answers.add(Set.copyOf(used));
            return;
        }
    
        for (String userId : matches.get(index)) {
            if (used.contains(userId)) {
                continue;
            }
            used.add(userId);
            dfs(index + 1, patterns, matches, used);
            used.remove(userId);
        }
    }
}