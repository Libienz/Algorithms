class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0, end = 0;
        int sum = 0;
        int[] result = {1000000, Integer.MAX_VALUE}; // 초기값으로 큰 값 설정

        while (end < sequence.length) {
            sum += sequence[end];

            // 현재 합이 k보다 크면 start를 이동하며 sum 조정
            while (sum > k && start <= end) {
                sum -= sequence[start++];
            }

            // 합이 정확히 k인 경우 결과 갱신
            if (sum == k) {
                if ((end - start < result[1] - result[0]) || 
                    (end - start == result[1] - result[0] && start < result[0])) {
                    result[0] = start;
                    result[1] = end;
                }
            }

            end++;
        }

        return result;
    }
}