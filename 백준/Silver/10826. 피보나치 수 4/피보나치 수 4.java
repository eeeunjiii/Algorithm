import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        BigInteger[] dp=new BigInteger[10_001];

        dp[0]=new BigInteger("0");
        dp[1]=new BigInteger("1");

        for(int i=2;i<=10_000;i++) {
            dp[i]=dp[i-1].add(dp[i-2]);
        }
        
        System.out.println(dp[N]);
    }
}