import java.io.*;
import java.util.*;
public class Main {
    private static final long MOD=1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine()); // 계단 수의 길이
        long[][] dp=new long[n+1][10];

        for(int i=1;i<10;i++){
            dp[1][i]=1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                if(j==0) dp[i][0]=dp[i-1][1]%MOD;
                else if(j==9) dp[i][9]=dp[i-1][8]%MOD;
                else dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%MOD;
            }
        }
        long answer=0;

        for(int i=0;i<10;i++){
            answer+=dp[n][i];
        }
        System.out.println(answer%MOD);
    }
}