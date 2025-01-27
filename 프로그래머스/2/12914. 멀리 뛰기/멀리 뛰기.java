class Solution {
    private static long count = 0L;
    
    
    public long solution(int n) {
        long[] fibbonacci = new long[n+1];
        fibbonacci[0] = 1L;
        fibbonacci[1] = 1L;
        
        for (int i = 2; i<=n; i++) {
            fibbonacci[i] = (fibbonacci[i-1] + fibbonacci[i-2])  % 1234567L;
        }
        return fibbonacci[n];
    }
    
}