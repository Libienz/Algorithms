class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = sequence.length - 1;
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while (right < sequence.length) {
            if (left > sequence.length) {
                break;
            }
            while (sum > k) {
                sum -= sequence[left++];
            }
            if (sum == k) {
                if (answer[1] - answer[0] > right - left) {
                    answer[0] = left;
                    answer[1] = right;   
                }
                sum -= sequence[left];
                left++; 
                if (left >= sequence.length) {
                    break;
                }
                continue;
            }
            if (sum < k) {
                right++;
                if (right >= sequence.length) {
                    break;
                }
                sum += sequence[right];
                continue;
            }
        }
        return answer;
    }
}