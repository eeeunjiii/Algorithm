class Solution {
    public long solution(int n) {
        long[] dp=new long[2001];
        
        // 1과 2로만 이루어진 조합 찾기 (순서 무관)
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3;i<=n;i++) {
            dp[i]=(dp[i-1])%1234567+(dp[i-2])%1234567;
        }
        return dp[n]%1234567;
    }
}