class Solution
{
    
    static int cnt=0;
    
    public int solution(int n, int a, int b)
    {
        dfs(a, b);
        return cnt;
    }
    
    static void dfs(int a, int b) {
        if(a==b) {
            return;
        }
        
        cnt++;
        dfs(a/2+a%2, b/2+b%2);
    }
}