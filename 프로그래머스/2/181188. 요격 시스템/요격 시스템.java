import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        List<AttackMissile> missiles = new ArrayList<>();
        for (int[] missile : targets) {
            missiles.add(new AttackMissile(missile[0], missile[1]));
        }
        
        Collections.sort(missiles); 
        
        int count = 0;
        int point = 0;
        for (AttackMissile am : missiles) {
            if (am.start >= point) {
                point = am.end;
                count++;
            }
        }
        return count;
    }
    
    private static class AttackMissile implements Comparable<AttackMissile> {
        private final int start;
        private final int end;
        
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
    }
}