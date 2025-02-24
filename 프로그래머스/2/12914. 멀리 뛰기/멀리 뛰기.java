class Solution {
    public long solution(int n) {
        long[] counts = new long[n + 1];
        counts[0] = 1L;
        counts[1] = 1L;
        for (int i = 2; i < n + 1; i++) {
            counts[i] = (counts[i-1] + counts[i-2]) % 1234567;
        }
        return counts[n];
    }
}