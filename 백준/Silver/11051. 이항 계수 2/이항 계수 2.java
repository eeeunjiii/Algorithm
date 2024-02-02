import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int K;
    private static int[][] dp=new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        dp[0][0]=1;

        for(int i=1;i<=N;i++){
            for(int j=0;j<=K;j++){
                if(i==j || j==0) dp[i][j]=1;
                else dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%10007;
            }
        }
        System.out.println(dp[N][K]);
    }
}