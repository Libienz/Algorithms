import java.util.*;

class Solution {
    
    private static Map<Path, Integer> distanceCache = new HashMap<>();
    
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
            
            distanceCache.put(new Path(start-1, dest-1),1);
            distanceCache.put(new Path(dest-1, start-1),1);
        }
        
        int[] answer = new int[sources.length];
        
        for (int i = 0; i<sources.length; i++) {
            int source = sources[i] - 1;
            int dest = destination - 1;
            int distance = calculateMinimumDistance(map, source, dest);
            
//             Path sourceToDest = new Path(source, dest);
//             Path destToSource = new Path(dest, source);
            
//             distanceCache.put(sourceToDest, distance);
//             distanceCache.put(destToSource, distance);
            
            answer[i] = distance;
        }
        return answer;
    }
    
    private int calculateMinimumDistance(List<Integer>[] map, int source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        boolean[] visited = new boolean[map.length];
        visited[source] = true;
        int level = 0; 
        
        while (!q.isEmpty()) {
            int len = q.size();
            
            for (int i = 0; i<len; i++) { 
                int cur = q.poll();
                Path pathToDestination = new Path(cur, destination);
                if (distanceCache.containsKey(pathToDestination)) {
                    int distanceToDest = distanceCache.get(pathToDestination);
                    if (distanceToDest == -1) {
                        return distanceToDest;
                    }
                    return distanceToDest + level;
                }
                // Path pathToHere = new Path(source, cur);
                // Path pathToThere = new Path(cur, source);
                // distanceCache.put(pathToHere, level);
                // distanceCache.put(pathToThere, level);
                
                if (cur == destination) {
                    return level;
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
        
        return -1;
    }
    
    private static class Path {
        int start;
        int dest;
        
        public Path(int start, int dest) {
            this.start = start;
            this.dest = dest;
        }
        
        @Override
        public boolean equals (Object target) {
            if (this == target) {
                return true;
            }
            if (target == null || getClass() != target.getClass()) {
                return false;
            }
            Path path = (Path) target;
            return start == path.start && dest == path.dest;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(start, dest);
        }
    }
}