class Solution {
    static final int mod = 1234567;
    public int solution(int n) {
        int[] dp = new int[1000001];
        dp[0] = 0; dp[1] = 1;
        
        for(int i=2; i<=n; i++) {
            dp[i] = (dp[i-1] % mod + dp[i-2] % mod) % mod;
        }
        
        return dp[n];
    }
}