import java.util.*;

class Solution {

    private static int holeCount = 0;
    public boolean solution(int[][] key, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0) {
                    holeCount++;
                }
            }
        }
        Key defaultKey = new Key(key);
        for (int r = 0; r < 4; r++) {
            for (int i = 1 - key.length; i < lock.length + key.length; i++) {
                for (int j = 1 - key.length; j < lock.length + key.length; j++) {
                    if (defaultKey.match(lock, i, j)) {
                        return true;
                    }
                }
            }
            defaultKey.rotateRight();
        }

        return false;
    }
    
    private static class Key {
        private int[][] key;
        
        public Key(int[][] key) {
            this.key = key;
        }
        
        public void rotateRight() {
            int[][] newKey = new int[key.length][key.length];
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    newKey[i][j] = key[key.length - 1 - j][i];
                }
            }
            key = newKey;
        }
        

        public boolean match(int[][] lock, int sr, int sc) {
            int matchCount = 0;
            
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    int keyOnLockRow = sr + i;
                    int keyOnLockCol = sc + j;
                    if (keyOnLockRow < 0 || keyOnLockCol < 0 || keyOnLockRow >= lock.length || keyOnLockCol >= lock.length) {
                        continue;
                    }
                    if (lock[keyOnLockRow][keyOnLockCol] == key[i][j]) {
                        return false;
                    }
                    if (lock[keyOnLockRow][keyOnLockCol] == 0 && key[i][j] == 1) {
                        matchCount++;
                    }
                }
            }

            return matchCount == holeCount;
        }
        
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < key.length; i++) {
                for(int j = 0; j < key.length; j++) {
                    result.append(String.valueOf(key[i][j]));
                }
                result.append("\n");
            }
            return result.toString();
        }
    }
}