import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
//        StringTokenizer st=new StringTokenizer(br.readLine());

        int T=Integer.parseInt(br.readLine());
        long[] dp=new long[101];

        dp[1]=dp[2]=dp[3]=1;
        dp[4]=dp[5]=2;

        for(int i=6;i<101;i++){
            dp[i]=dp[i-1]+dp[i-5];
        }
        for(int i=0;i<T;i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}