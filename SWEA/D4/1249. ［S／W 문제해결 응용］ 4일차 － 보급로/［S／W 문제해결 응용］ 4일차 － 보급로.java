import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;
    static final int[] dx={-1,1,0,0};
    static final int[] dy={0,0,-1,1};
    static int sum=0;
    static int min;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N=sc.nextInt();
            map=new int[N][N];
            visited=new boolean[N][N];
            dp=new int[N][N];
            
            min=Integer.MAX_VALUE;
            
            for(int i=0;i<N;i++) {
            	String str=sc.next();
                for(int j=0;j<N;j++) {
                	map[i][j]=str.charAt(j)-'0';
                    dp[i][j]=Integer.MAX_VALUE;
                }
            }
            bfs(0,0);
            System.out.println("#"+test_case+" "+min);
		}
	}
    
    static void bfs(int i, int j) {
    	Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j]=true;
        
        dp[i][j]=0;
        
        while(!queue.isEmpty()) {
        	int[] v=queue.poll();
            int x=v[0];
            int y=v[1];
            
            if(x==N-1 && y==N-1) min=Math.min(min, dp[N-1][N-1]);
            if(min<=dp[x][y]) continue;
            
            for(int d=0;d<4;d++) {
            	int nx=x+dx[d];
                int ny=y+dy[d];
                
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(!visited[nx][ny] || dp[nx][ny]>dp[x][y]+map[nx][ny]) {
                	visited[nx][ny]=true;
                    dp[nx][ny]=dp[x][y]+map[nx][ny];
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}