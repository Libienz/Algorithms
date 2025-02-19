import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times); // 가장 빠른 심사 시간을 찾기 위해 정렬

        long start = 1; // 최소 1분부터 시작
        long end = (long) times[times.length - 1] * n; // 가장 느린 심사관이 모든 인원을 처리할 때 걸리는 최대 시간
        long answer = end;

        while (start <= end) {
            long mid = (start + end) / 2;
            long processCount = 0;

            // mid 시간 동안 처리할 수 있는 총 인원 계산
            for (int time : times) {
                processCount += mid / time;
                if (processCount >= n) break; // 더 계산할 필요 없음
            }

            if (processCount >= n) {
                answer = mid; // 더 짧은 시간으로 시도 가능
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}