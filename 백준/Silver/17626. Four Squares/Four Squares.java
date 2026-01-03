import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] dp=new int[50_001];

        // 제곱수들의 최소 개수
        // dp[1]=1, dp[2]=dp[1]+1, dp[3]=dp[3-1^2]+d[1^2]
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1]=1;

        for(int i=2;i<=50000;i++) {
            for(int j=1;j*j<=i;j++) {
                if(i==j*j) dp[i]=1;
                else dp[i]=Math.min(dp[i], dp[i-j*j]+dp[j*j]);
            }
        }
        System.out.println(dp[N]);
    }
}