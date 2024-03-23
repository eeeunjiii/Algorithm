import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 동전 종류의 개수
        int K=Integer.parseInt(st.nextToken()); // 동전의 값
        int[] coin=new int[N+1];
        int[] dp=new int[K+1];

        for(int i=1;i<=N;i++) {
            coin[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin);

        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0]=0;

        for(int i=1;i<=N;i++) {
            for(int j=coin[i];j<=K;j++) {
                dp[j]=Math.min(dp[j], dp[j-coin[i]]+1);
            }
        }

        if(dp[K]==Integer.MAX_VALUE-1) dp[K]=-1;
        System.out.println(dp[K]);
    }
}