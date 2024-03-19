import java.util.*;

class Solution {
    
    private static int[][] graph;
    
    public int solution(int n, int[][] results) {
        int answer=0;
        
        graph=new int[n+1][n+1];
        
        for(int i=0;i<results.length;i++) {
            int a=results[i][0];
            int b=results[i][1];
            
            graph[a][b]=1;
        }
        
        for(int j=1;j<=n;j++) { // 중간
            for(int i=1;i<=n;i++) { // 시작
                if(i==j) continue;
                
                for(int l=1;l<=n;l++) { // 끝
                    if(j==l || i==l) continue;
                    if(graph[i][j]==1 && graph[j][l]==1) {
                        graph[i][l]=1;
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++) {
            int cnt=0;
            for(int j=1;j<=n;j++) {
                if(graph[i][j]==1 || graph[j][i]==1) cnt++;
            }
            if(cnt==n-1) answer++; // 자기 자신 제외
        }
        return answer;
    }
}