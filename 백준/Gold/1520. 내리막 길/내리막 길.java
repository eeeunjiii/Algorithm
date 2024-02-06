import java.io.*;
import java.util.*;

public class Main {
    private static int M; // 행
    private static int N; // 열
    private static int[][] map;
    private static int[][] dp;
    private static long ans=0L;
    private static int[] dx={-1,1,0,0}; // 행
    private static int[] dy={0,0,-1,1}; // 열

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        map=new int[M][N];
        dp =new int[M][N];

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        }
        System.out.println(dfs(0,0));
    }

    private static int dfs(int x, int y) {
        if(x==M-1 && y==N-1){
            return 1;
        }

        if(dp[x][y]!=-1) return dp[x][y]; // 해당 지점을 이미 한 번 이상 지나간 경우 (메모제이션)
        else {
            dp[x][y]=0;

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                if(map[x][y]>map[nx][ny]){
                    dp[x][y]+=dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}