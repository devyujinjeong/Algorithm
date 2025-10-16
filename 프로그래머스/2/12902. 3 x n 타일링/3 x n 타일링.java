class Solution {
    public int solution(int n) {
        int mod = 1000000007;
        
        if(n%2==1) return 0;
        
        long[] dp = new long[n+1];
        
        dp[2] = 3; dp[4] = 11;
        for(int i=6; i<=n; i+=2) {
            dp[i] = (4 * (dp[i-2] % mod) - (dp[i-4] % mod)) % mod;
            if(dp[i]<0) dp[i] += mod;
        }
        
        return (int)dp[n];
    }
}