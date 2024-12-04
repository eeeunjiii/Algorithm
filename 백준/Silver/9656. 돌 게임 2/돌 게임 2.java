import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] dp=new int[1001];

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=1;

        for(int i=4;i<=N;i++) {
            dp[i]=dp[3]+dp[i-3];
        }

        if(dp[N]%2==0) System.out.println("SK");
        else System.out.println("CY");
    }
}