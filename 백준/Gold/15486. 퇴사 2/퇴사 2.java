import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] T=new int[N+2];
        int[] P=new int[N+2];
        int[] dp=new int[N+2];

        StringTokenizer st;
        for(int i=1;i<=N;i++) {
            st=new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }

        int max=Integer.MIN_VALUE;
        for(int i=1;i<=N+1;i++) {
            if(max<dp[i]) {
                max=dp[i];
            }
            if(i+T[i]<=N+1) {
                dp[i+T[i]]=Math.max(max+P[i], dp[i+T[i]]);
            }
        }
        System.out.println(dp[N+1]);
    }
}