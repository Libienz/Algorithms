class Solution {
    int count = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n+1];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            count++;
            dfs(i, computers, visited);
        }
        
        return count;
    }
    
    public void dfs(int cur, int[][] computers, boolean[] visited) {
        visited[cur] = true;
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] || computers[cur][i] == 0) {
                continue;
            }
            dfs(i, computers, visited);
        }
    }
}