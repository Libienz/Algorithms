import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        List<AttackMissile> missiles = new ArrayList<>();
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            missiles.add(new AttackMissile(start, end));
        }
        
        Collections.sort(missiles);
        
        int point = 0;
        int count = 0;
        for (AttackMissile missile : missiles) {
            if (missile.start >= point) {
                count++;
                point = missile.end;
            } 
        }
        
        return count;
    }
    
    private static class AttackMissile implements Comparable<AttackMissile> {
        int start;
        int end;
        
        public AttackMissile(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(AttackMissile other) {
            if (this.end == other.end) {
                return this.start - other.start;    
            }
            return this.end - other.end;
        }
        
        @Override
        public String toString() {
            return "start: " + start + " end: " + end;
        }
    }
}