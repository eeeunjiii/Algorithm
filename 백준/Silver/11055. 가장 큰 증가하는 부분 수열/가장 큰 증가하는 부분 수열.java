import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] dp;
    private static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N+1];
        dp=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dp[1]=arr[1];

        for(int i=1;i<=N;i++) {
            dp[i]=arr[i];

            for(int j=1;j<i;j++){
                if(arr[j]<arr[i]) dp[i]=Math.max(dp[j]+arr[i], dp[i]);
            }
            max=Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}