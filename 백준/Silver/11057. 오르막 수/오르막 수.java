import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        long[][] dp=new long[10001][10];
        // 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지 출력

        for(int i=0;i<=9;i++) {
            dp[1][i]=1;
        }

        for(int i=2;i<=N;i++) {
            for(int j=0;j<=9;j++) {
                for(int l=0;l<=j;l++) {
                    dp[i][j]+=dp[i-1][l];
                    dp[i][j]%=10007;
                }
            }
        }

        long ans=0;
        for(int i=0;i<=9;i++) {
            ans+=dp[N][i];
        }
        System.out.println(ans%10007);
    }
}