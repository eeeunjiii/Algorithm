import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        int[][] board=new int[N][3];
        int[][][] dp=new int[N][3][2]; // 0: 최대, 1: 최소

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0][0]=dp[0][0][1]=board[0][0];
        dp[0][1][0]=dp[0][1][1]=board[0][1];
        dp[0][2][0]=dp[0][2][1]=board[0][2];

        for(int i=1;i<N;i++) {
            dp[i][0][0]=board[i][0]+Math.max(dp[i-1][0][0], dp[i-1][1][0]);
            dp[i][0][1]=board[i][0]+Math.min(dp[i-1][0][1], dp[i-1][1][1]);

            dp[i][1][0]=board[i][1]+Math.max(dp[i-1][0][0], Math.max(dp[i-1][1][0], dp[i-1][2][0]));
            dp[i][1][1]=board[i][1]+Math.min(dp[i-1][0][1], Math.min(dp[i-1][1][1], dp[i-1][2][1]));

            dp[i][2][0]=board[i][2]+Math.max(dp[i-1][1][0], dp[i-1][2][0]);
            dp[i][2][1]=board[i][2]+Math.min(dp[i-1][1][1], dp[i-1][2][1]);
        }

        max=Math.max(dp[N-1][0][0], Math.max(dp[N-1][1][0], dp[N-1][2][0]));
        min=Math.min(dp[N-1][0][1], Math.min(dp[N-1][1][1], dp[N-1][2][1]));

        System.out.println(max+" "+min);
    }
}