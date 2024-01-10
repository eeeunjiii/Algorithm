import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();

        dp=new int[1001];

        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }
        System.out.println(dp[N]);
    }
}