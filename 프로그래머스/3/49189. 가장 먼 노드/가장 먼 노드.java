import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] graph = new ArrayList[n];
        
        for (int i= 0 ;i<n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int[] e : edge ) {
            int start = e[0] - 1;
            int end = e[1] - 1;
            
            graph[start].add(end);
            graph[end].add(start);
        } 
        
        
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            answer = size;
            for (int i = 0; i<size; i++) {
                int start = q.poll();
                for (int end : graph[start]) {
                    if (visited[end]) {
                        continue;
                    }
                    q.add(end);
                    visited[end] = true;
                }
            }
            level++;
        }
        
        return answer;
    }
}