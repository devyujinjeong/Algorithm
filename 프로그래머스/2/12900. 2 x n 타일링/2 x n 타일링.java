class Solution {
    public long solution(int n) {
        long[] dp = new long[n+1];
        final long mod = 1000000007;
        dp[1] = 1; 
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1]%mod+dp[i-2]%mod)%mod; 
        }

        return dp[n];
    }
}