import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());

        int[] T=new int[N+1]; // 걸리는 기간
        int[] P=new int[N+1]; // 금액
        int[] dp=new int[N+1];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            if(i+T[i]<=N){
                dp[i+T[i]]=Math.max(P[i]+dp[i], dp[i+T[i]]);
            }
            dp[i+1]=Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[N]);
    }
}