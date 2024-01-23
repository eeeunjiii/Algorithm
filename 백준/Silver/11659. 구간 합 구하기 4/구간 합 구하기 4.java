import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        dp=new long[N+1];

        st=new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            dp[i]=dp[i-1]+Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            System.out.println(dp[end]-dp[start-1]);
        }
    }
}