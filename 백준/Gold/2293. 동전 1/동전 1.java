import java.io.*;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class Main {

    private static int N;
    private static int K;
    private static int[] value;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        value=new int[N];
        dp=new int[K+1];

        for(int i=0;i<N;i++){
            value[i]=Integer.parseInt(br.readLine());
        }

        dp[0]=1;
        for(int i=0;i<N;i++){
            for(int j=1;j<=K;j++){
                if(j>=value[i]){
                    dp[j]=dp[j]+dp[j-value[i]];
                }
            }
        }
        System.out.println(dp[K]);
    }
}