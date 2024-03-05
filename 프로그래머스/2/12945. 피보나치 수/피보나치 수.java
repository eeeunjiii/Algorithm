class Solution {
    public int solution(int n) {
        int[] dp=new int[n+1];
        int num=1234567;
        
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<=n;i++) {
            dp[i]=(dp[i-1]%num)+(dp[i-2]%num);
        }
        return dp[n]%num;
    }
}