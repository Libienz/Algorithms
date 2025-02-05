import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Queue<Bridge> bridges = new PriorityQueue<>();
    
        for (int i = 0; i < costs.length; i++) {
            bridges.add(new Bridge(costs[i][0], costs[i][1], costs[i][2]));
        }
    
        int result = 0;
        int selectCount = 0;
        
        int[] parent = new int[n];
        for (int i = 0; i< n; i++) {
            parent[i] = i;
        }
        while (selectCount != n-1) {   
            Bridge cur = bridges.poll();
            if (find(cur.start, parent) != find(cur.end, parent)) {
                union(cur.start, cur.end, parent);
                selectCount++;
                result += cur.cost;
            }
        }
        return result;
    }
    
    public int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x], parent);
    }
    
    public void union(int x, int y, int[] parent) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        parent[rootX] = rootY;
    }
    private static class Bridge implements Comparable<Bridge> {
        int start;
        int end;
        int cost;
        
        public Bridge(int start, int end, int cost) {
            this.start = start; 
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Bridge other) {
            return this.cost - other.cost;
        }
    }
}