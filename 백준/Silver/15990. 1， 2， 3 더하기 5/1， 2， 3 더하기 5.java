import java.io.*;
import java.util.*;

public class Main {

    static final int MOD=1_000_000_009;
    static long[][] dp=new long[100_001][4]; // 합을 표현할 때 끝나는 숫자가 1, 2, 3인 경우

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        // N을 1, 2, 3의 합으로만 나타내는 방법의 수
        // 같은 수를 2번 이상 사용 불가
        dp[1][1]=1;
        dp[2][2]=1;
        dp[3][1]=1; // 1+1+1은 불가
        dp[3][2]=1;
        dp[3][3]=1;

        for (int i=4;i<=100_000;i++) {
            dp[i][1]=(dp[i-1][2]+dp[i-1][3])%MOD;
            dp[i][2]=(dp[i-2][1]+dp[i-2][3])%MOD;
            dp[i][3]=(dp[i-3][1]+dp[i-3][2])%MOD;
        }

        int T=Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N=Integer.parseInt(br.readLine());
            long ans=(dp[N][1]+dp[N][2]+dp[N][3])%MOD;
            System.out.println(ans);
        }
    }
}