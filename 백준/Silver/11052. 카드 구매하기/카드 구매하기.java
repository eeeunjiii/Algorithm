import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[] P;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());

        P =new int[N+1];
        dp=new long[N+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            P[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i]=Math.max(dp[i], dp[i-j]+P[j]);
            }
        }
        System.out.println(dp[N]);
    }
}