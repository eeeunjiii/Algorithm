import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] graph;
    private static int[][] dp;
    private static final int[] dx={-1,1,0,0};
    private static final int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        graph=new int[N][N];
        dp=new int[N][N];

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int cnt=Integer.MIN_VALUE;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                cnt=Math.max(cnt, dfs(i, j));
            }
        }
        System.out.println(cnt);
    }

    private static int dfs(int x, int y) { // 개수를 하나씩 증가시키기

        if(dp[x][y]!=0) {
            return dp[x][y];
        }

        dp[x][y]=1; // 해당 위치에서 살게 되면 1로 저장

        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if(graph[x][y]<graph[nx][ny]) {
                dp[x][y]=Math.max(dp[x][y], dfs(nx, ny)+1); // +1 중요
            }
        }
        return dp[x][y];
    }
}