import java.io.*;
import java.util.*;

public class Main {

    static int[] dx={1,0,1};
    static int[] dy={0,1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] map=new int[N+1][M+1];
        int[][] dp=new int[N+1][M+1];

        for(int i=1;i<=N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                map[i][j]=dp[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                for(int l=0;l<3;l++) {
                    int nx=i+dx[l];
                    int ny=j+dy[l];

                    if(nx>=N+1 || ny>=M+1) continue;

                    dp[nx][ny]=Math.max(dp[nx][ny], dp[i][j]+map[nx][ny]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}