import java.io.*;
import java.util.*;
public class Main {
    private static final int[] dp=new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<dp.length;i++){
            dp[i]=0;
        }
        System.out.println(Tile(N));
    }
    public static int Tile(int N){
        if(N!=0 && dp[N]==0){
            dp[N]=(Tile(N-1)+Tile(N-2))%15746;
        }
        return dp[N];
    }
}