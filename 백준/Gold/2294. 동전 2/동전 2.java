import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int K;
    private static int[] num;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        num=new int[N+1];
        dp=new int[K+1];

        for(int i=1;i<=K;i++) {
            dp[i]=Integer.MAX_VALUE-1;
        }

        for(int i=1;i<=N;i++) {
            num[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(num); // 오름차순 정렬

        for(int i=1;i<=N;i++) { // num
            for(int j=num[i];j<=K;j++) { // num[i]~K (이렇게 하면 굳이 num이 j보다 작은 경우를 고려하지 않아도 됨. 이미 여기서 처리)
                dp[j]=Math.min(dp[j], dp[j-num[i]]+1); // num을 더하기 이전의 인덱스를 가진 dp 값에 +1만 해주면 됨.
            }
        }
        if(dp[K]==Integer.MAX_VALUE-1) dp[K]=-1;

        System.out.println(dp[K]);
    }
}