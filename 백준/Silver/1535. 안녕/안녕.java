import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] L=new int[N+1];
        int[] J=new int[N+1];
        int[][] dp=new int[N+1][101];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            L[i]=Integer.parseInt(st.nextToken());
        }
        
        st=new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            J[i]=Integer.parseInt(st.nextToken());
        }
        
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=99;j++) {
                if (L[i]<=j) {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-L[i]]+J[i]);
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][99]);
    }
}