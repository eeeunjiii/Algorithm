import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        long[] dp=new long[100_001];

        dp[1]=3;
        dp[2]=7;

        for(int i=3;i<=100_000;i++) {
             dp[i]=(dp[i-1]-dp[i-2])*2+(dp[i-2]*3);
             dp[i]%=9901;
        }
        System.out.println(dp[N]%9901);
    }
}