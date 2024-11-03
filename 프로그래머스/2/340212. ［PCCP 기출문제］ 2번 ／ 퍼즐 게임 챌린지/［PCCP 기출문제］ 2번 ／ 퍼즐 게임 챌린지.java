class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Integer.MAX_VALUE -1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long solveTime = calcSolveTime(diffs, times, mid);
            if (solveTime <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    
    public long calcSolveTime(int[] diffs, int[] times, int level) {
        long solveTime = 0l;
        
        for (int i = 0; i<diffs.length; i++) {
            int diffCur = diffs[i];
            int timeCur = times[i];
            if (diffCur <= level) {
                solveTime += timeCur;
            } else {
                long wrongTime = diffCur - level;
                int timePrev;
                if (i == 0) {
                    timePrev = 0;
                } else {
                    timePrev = times[i-1];
                }
                solveTime += ((timePrev + timeCur) * wrongTime) + timeCur;
            }
        }
        return solveTime;
    }
}