import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][2];
        int[][] dp=new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            arr[i][0]=a;
            arr[i][1]=b;
        }

        for(int d=1;d<N;d++) {
            for(int i=0;i+d<N;i++) {
                dp[i][i+d]=Integer.MAX_VALUE;
                for(int j=i;j<i+d;j++) {
                    dp[i][i+d]=Math.min(dp[i][i+d], dp[i][j]+dp[j+1][i+d]+arr[i][0]*arr[j][1]*arr[i+d][1]);
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
}