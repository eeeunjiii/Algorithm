import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        int[][] dp=new int[N][2]; // 커지는 경우, 작아지는 경우

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dp[0][0]=dp[0][1]=1;
        
        for(int i=1;i<N;i++) {
            if(arr[i-1]<=arr[i]) { // 증가하는 경우
                dp[i][0]=dp[i-1][0]+1;
            } else {
                dp[i][0]=1;
            }

            if(arr[i-1]>=arr[i]) { // 감소하는 경우
                dp[i][1]=dp[i-1][1]+1;
            } else {
                dp[i][1] = 1;
            }
        }
        
        int max=0;
        for(int i=0;i<N;i++) {
            max=Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }
}