import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N+1];
        int[] dp=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int max=0;
        for(int i=1;i<=N;i++) {
            for(int j=0;j<i;j++) {
                if (arr[j]<arr[i]) {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                    max=Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(max);
    }
}