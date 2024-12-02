import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] board;
    private static long[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        board=new int[N][N];
        dp=new long[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0]=1;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i==N-1 && j==N-1) break;
                
                int cnt=board[i][j];

                if(i+cnt<N) {
                    dp[i+cnt][j]+=dp[i][j];
                }
                if(j+cnt<N) {
                    dp[i][j+cnt]+=dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}