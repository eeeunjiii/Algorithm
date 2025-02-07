import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        double[] arr=new double[N+1];
        double[] dp=new double[N+1];

        for(int i=1;i<=N;i++) {
            arr[i]=Double.parseDouble(br.readLine());
        }

        Arrays.fill(dp, 1);
        double max=Double.MIN_VALUE;

        for(int i=1;i<N;i++) {
            dp[i]=Math.max(arr[i], dp[i-1]*arr[i]);
            max=Math.max(max, dp[i]);
        }
        System.out.println(String.format("%.3f", max));
    }
}