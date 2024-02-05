import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] dp; // 오르막 수의 길이, 오르막 수의 마지막 수

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        dp=new int[N+1][10];

        for(int i=0;i<10;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++){
                for(int l=0;l<=j;l++){
                    dp[i][j]+=dp[i-1][l];
                    dp[i][j]%=10007;
                }
            }
        }

        long ans=0;
        for(int i=0;i<10;i++){
            ans+=dp[N][i];
        }

        System.out.println(ans%10007);
    }
}