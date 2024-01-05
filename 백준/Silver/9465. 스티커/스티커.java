import java.io.*;
import java.util.*;
public class Main {
    private static int T;
    private static int N;
    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());

        T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());

            arr=new int[2][N+1];
            dp=new int[2][N+1];

            for(int j=0;j<2;j++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                for(int l=1;l<=N;l++){
                    arr[j][l]=Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1]=arr[0][1];
            dp[1][1]=arr[1][1];

            for(int j=2;j<N+1;j++){
                dp[0][j]=Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j]=Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}