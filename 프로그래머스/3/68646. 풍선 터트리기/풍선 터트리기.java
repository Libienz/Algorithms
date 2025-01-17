import java.util.*;

class Solution {
    public int solution(int[] a) {
        
        int res = 0;
        
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        for (int i = 0; i<a.length; i++) {
            if (i == 0) { 
                leftMin[i] = Integer.MAX_VALUE;
                continue;
            }
            if (i == 1) {
                leftMin[i] = a[i-1];
                continue;
            }
            leftMin[i] = Math.min(leftMin[i-1], a[i-1]);
        }

        for (int i = a.length-1; i>=0; i--) {
            if (i == a.length-1) { 
                rightMin[i] = Integer.MAX_VALUE;
                continue;
            }
            if (i == a.length-2) {
                rightMin[i] = a[i+1];
                continue;
            }
            rightMin[i] = Math.min(rightMin[i+1], a[i+1]);
        }
        
        for (int i = 0 ;i<a.length; i++) {
            if (leftMin[i] < a[i] && rightMin[i] < a[i]) {
                continue;
            }
            res++;
        }
        return res;
    }
}