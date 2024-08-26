import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        long[] dp=new long[1000001];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=4;i<1000001;i++) {
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1_000_000_009;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++) {
            int N=Integer.parseInt(br.readLine());
            sb.append(dp[N]%1_000_000_009).append("\n");
        }

        System.out.println(sb);
    }
}