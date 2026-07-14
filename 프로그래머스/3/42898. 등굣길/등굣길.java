import java.util.*;

class Solution {
    static int[] dr={1, 0};
    static int[] dc={0, 1};
    static int[][] dp;
    static int M, N;
    static int ans=0;
    
    public int solution(int m, int n, int[][] puddles) {
        M=m;
        N=n;
        
        dp=new int[N][M];
        for (int i=0;i<N;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(0, 0, puddles)%1_000_000_007;
    }
    
    static public int dfs(int r, int c, int[][] puddles) {
        if (r==N-1 && c==M-1) return 1;
        
        if (dp[r][c]!=-1) return dp[r][c]%1_000_000_007;
        else {
            dp[r][c]=0;
            
            for (int i=0;i<2;i++) {
                int nr=r+dr[i];
                int nc=c+dc[i];

                if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if (!isPuddle(nr, nc, puddles)) {
                    dp[r][c]=(dp[r][c]+dfs(nr, nc, puddles))%1_000_000_007;
                }
            }
        }
        
        return dp[r][c];
    }
    
    static boolean isPuddle(int r, int c, int[][] puddles) {
        for (int i=0;i<puddles.length;i++) {
            int puddleR=puddles[i][1]-1;
            int puddleC=puddles[i][0]-1;
            
            if (r==puddleR && c==puddleC) return true;
        }
        return false;
    }
}