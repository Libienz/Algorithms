import java.util.*;

class Solution {
    
    private static int[] moveR = {-1,1,0,0};
    private static int[] moveC = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int level = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.r == maps.length - 1 && cur.c == maps[0].length - 1) {
                    return level;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + moveR[j];
                    int nc = cur.c + moveC[j];
                    
                    if (nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length || visited[nr][nc] || maps[nr][nc] == 0) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    q.add(new Node(nr,nc));
                }
            }
            level++;
        }
        return -1;
    }
    
    
    private static class Node {
        int r;
        int c; 
        
        private Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}