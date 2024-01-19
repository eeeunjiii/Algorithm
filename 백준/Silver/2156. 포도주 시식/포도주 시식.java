import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br;
    private static int[] grape={0,};
    private static int[] dp={0,};
    private static int n=0;
    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        grape=new int[n+1]; // 1~n, length: n+1
        dp=new int[n+1];

        for(int i=1;i<=n;i++){
            grape[i]=Integer.parseInt(br.readLine());
        }

        dp[1]=grape[1];
        if(n>1) dp[2]=grape[1]+grape[2];

        for(int i=3;i<=n;i++){
            dp[i]=Math.max(dp[i-1], Math.max(dp[i-2]+grape[i], dp[i-3]+grape[i-1]+grape[i]));
        }
        System.out.println(dp[n]);
    }
}