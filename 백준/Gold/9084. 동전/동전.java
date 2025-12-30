import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int T=Integer.parseInt(br.readLine());
        while(T-->0) {
            int N=Integer.parseInt(br.readLine()); // 사용할 수 있는 동전의 가지 수
            int[] coin=new int[N];

            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                coin[i]=Integer.parseInt(st.nextToken());
            }
            int M=Integer.parseInt(br.readLine()); // 만들어야 할 금액
            int[] dp=new int[M+1];

            // 주어진 금액을 만드는 모든 방법을 세야 함.
            // dp[1]=1, dp[2]=2, dp[3]=1, dp[4]=3
            for(int i=0;i<N;i++) {
                for(int j=1;j<=M;j++) {
                    if(j-coin[i]>0) {
                        dp[j]=dp[j]+dp[j-coin[i]]; // dp[4]=dp[4]+dp[3], dp[2], dp[1] -> coin[i]에 해당하는 뒤에 붙였다고 생각하면 됨.
                    } else if(j-coin[i]==0) {
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}