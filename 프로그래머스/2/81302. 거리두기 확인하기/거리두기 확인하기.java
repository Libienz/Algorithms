import java.util.*;

class Solution {
    private static int[] moveR = {-1,1,0,0};
    private static int[] moveC = {0,0,1,-1};
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        for (int i = 0; i<places.length; i++) {
            String[] place = places[i];
            answer[i] = isWellDistanced(place);
        }
        
        return answer;
    }
    
    public int isWellDistanced(String[] place) {
        char[][] map = new char[place.length][place[0].toCharArray().length];
        
        for (int i = 0; i<place.length; i++) {
            char[] line = place[i].toCharArray();
            for (int j = 0; j<line.length; j++) {
                map[i][j] = line[j];
            }
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'P') {
                    boolean personWellDistanced = isPersonWellDistanced(new Position(i,j), map);
                    if (!personWellDistanced) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    public boolean isPersonWellDistanced(Position personPosition, char[][] map) {
        Queue<Position> q = new LinkedList<>();
        q.add(personPosition);
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[personPosition.row][personPosition.col] = true;
        int level = 0;
        
        while (!q.isEmpty() && level <= 1) {
            int len = q.size();
            for (int i = 0; i<len; i++) {
                Position cur = q.poll();
                for (int j = 0; j<4; j++) {
                    int nr = cur.row + moveR[j];
                    int nc = cur.col + moveC[j];
                    if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    if (map[nr][nc] == 'X') {
                        continue;
                    }
                    if (map[nr][nc] == 'P') {
                        return false;
                    }
                    Position np = new Position(nr, nc);
                    visited[nr][nc] = true;
                    q.add(np);
                }
            }
            level++;
        }
        return true;
    }
    
    private static class Position {
        int row;
        int col;
        
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}