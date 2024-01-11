import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(br.readLine());
        arr=new int[301];
        dp=new int[301];

        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        dp[0]=0; // 시작점
        dp[1]=arr[1];
        dp[2]=arr[1]+arr[2];

        for(int i=3;i<=N;i++){
            dp[i]=Math.max(dp[i-2], dp[i-3]+arr[i-1])+arr[i];
        }
        System.out.println(dp[N]);
    }
}