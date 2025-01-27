import java.util.*;

class Solution {
    private List<Dungeon> dungeonList = new ArrayList<>();
    private boolean[] checked;
    private int maxCount = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        for (int[] dungeon : dungeons) {
            dungeonList.add(new Dungeon(dungeon[0], dungeon[1]));
        }
        
        checked = new boolean[dungeonList.size()];
        dfs(k, 0);
        return maxCount;
    }
    
    private void dfs(int k, int count) {

        if (isAllChecked(checked)) {
            maxCount = Math.max(maxCount, count);
            return;
        }
        
        for (int i = 0 ; i < dungeonList.size(); i++) {
            Dungeon cur = dungeonList.get(i);
            if (checked[i] == true) {
                continue;
            }
            checked[i] = true;
            if (k >= cur.mf) {
                dfs(k-cur.cf, count+1);
            } else {
                dfs(k, count);
            }
            checked[i] = false;
        }
    }
    
    private boolean isAllChecked(boolean[] isChecked) {
        for (boolean c : isChecked) {
            if (!c) {
                return false;
            }
        }
        return true;
    }
    private static class Dungeon {
        int mf;
        int cf; 
        
        public Dungeon(int mf, int cf) {
            this.mf = mf;
            this.cf = cf;
        }
    }
}