import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        // B에서 버튼을 누르면 A가 하나 증가 (BA)
        // A에서 버튼을 누르면 A하나 감소, B 하나 증가 (B)

        int K=Integer.parseInt(br.readLine());
        int[][] dp=new int[46][2]; // A, B

        dp[2][0]=1;
        dp[1][1]=1;
        dp[2][1]=1;
        for(int i=3;i<=K;i++) {
            dp[i][0]=dp[i-2][0]+dp[i-1][0];
            dp[i][1]=dp[i-2][1]+dp[i-1][1];
        }

        System.out.println(dp[K][0]+" "+dp[K][1]);
    }
}