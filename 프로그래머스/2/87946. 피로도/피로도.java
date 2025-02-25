import java.util.*;

class Solution {
    private static int answer = Integer.MIN_VALUE;
    private static int cheapest = Integer.MAX_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        List<Dungeon> dungeonList = new ArrayList<>();
        for (int [] d : dungeons) {
            cheapest = Math.min(d[0], cheapest);
            dungeonList.add(new Dungeon(d[0], d[1]));
        }
        
        dfs(k, dungeonList, new ArrayList<>());    
        
        if (answer == Integer.MIN_VALUE) {
            return 0;
        }
        return answer;
    }
    
    public void dfs (int fatigue, List<Dungeon> dungeons, List<Integer> chosen) {
        answer = Math.max(chosen.size(), answer);
        
        for (int i = 0; i < dungeons.size(); i++) {
            Dungeon d = dungeons.get(i);
            if (d.canExplore(fatigue) && !chosen.contains(i)) {
                chosen.add(i);
                dfs(fatigue - d.cost, dungeons, chosen);
                chosen.remove(chosen.size() - 1);
            }
        }

    }
    
    private static class Dungeon {
        int minFatigue;
        int cost;
        
        public Dungeon(int minFatigue, int cost) {
            this.minFatigue = minFatigue;
            this.cost = cost;
        }
        
        public boolean canExplore(int fatigue) {
            return fatigue >= minFatigue;
        }
    }
}