import java.util.*;

class Solution {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] map = new ArrayList[n];
        for (int i = 0; i<n; i++) {
            map[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int start = road[0];
            int dest = road[1];
            
            map[start-1].add(dest-1);
            map[dest-1].add(start-1);
        }
        
        return calculateMinimumDistance(map, destination-1, sources);
    }
    
    private int[] calculateMinimumDistance(List<Integer>[] map, int source, int[] destinations) {
        int[] answer = new int[destinations.length];
        Arrays.fill(answer, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        boolean[] visited = new boolean[map.length];
        visited[source] = true;
        int level = 0; 
        
        while (!q.isEmpty()) {
            int len = q.size();
            
            for (int i = 0; i<len; i++) { 
                int cur = q.poll();
                for (int j = 0; j<destinations.length; j++) {
                    if (destinations[j]-1 == cur) {
                        answer[j] = level;
                    }
                }
                for (int next : map[cur]) { 
                    if (visited[next]) {
                        continue;
                    }
                    q.add(next);
                    visited[next] = true;
                }
            }
            level++;
        }
        
        return answer;
    }
}