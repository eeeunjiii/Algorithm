import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());
       N=Integer.parseInt(br.readLine());
       dp=new int[N+1];

       dp[1]=1;

       for(int i=2;i<=N;i++) {
           if(i%3==0) dp[i]=i/3;
           else dp[i]=dp[i-1]+1;
       }

       if(dp[N]%2==0) {
           System.out.println("CY");
       } else {
           System.out.println("SK");
       }
    }
}