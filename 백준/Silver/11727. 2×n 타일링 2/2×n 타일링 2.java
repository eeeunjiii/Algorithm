import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        int[] dp=new int[1001];

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        dp[1]=1;
        dp[2]=3;

        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2]*2)%10007;
        }
        System.out.println(dp[n]);
    }
}