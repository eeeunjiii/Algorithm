import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] dp;
    private static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        dp=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1); // 처음에는 자기 자신만 있는 것으로 초기화

        for(int i=0;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(arr[i]<arr[j] && dp[i]<dp[j]+1) {
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}