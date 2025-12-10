import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // N행
        int K=Integer.parseInt(st.nextToken()); // K번째
        int[][] dp=new int[31][31];

        for(int i=1;i<=30;i++) {
            dp[i][1]=1;
            dp[i][i]=1;
        }

        for(int i=3;i<=N;i++) {
            for(int j=2;j<i;j++) {
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }

        System.out.println(dp[N][K]);
    }
}