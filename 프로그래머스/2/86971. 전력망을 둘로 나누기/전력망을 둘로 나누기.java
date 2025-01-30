import java.util.*;

class Solution {
    
    int count = 0;
    
    public int solution(int n, int[][] wires) {
        boolean[][] graph = new boolean[n][n];
        
        for (int[] edge : wires) {
            int start = edge[0] - 1;
            int end = edge[1] - 1;
            graph[start][end] = true;
            graph[end][start] = true;
        }
        
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!graph[i][j]) {
                    continue;
                }
                graph[i][j] = false;
                graph[j][i] = false;
                
                count = 0;
                dfs(0, graph, new boolean[n]);
                
                if (Math.abs(count - (n-count)) < answer) {
                    answer = Math.abs(count - (n-count)); 
                }
                
                graph[i][j] = true;
                graph[j][i] = true;
            }
        }
        
        return answer;
    }
    
    public void dfs(int start, boolean[][] graph, boolean[] visited) {
        count++;
        visited[start] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] && !visited[i]) {
                visited[i] = true;
                dfs(i, graph, visited);
            }
        }
    }
}