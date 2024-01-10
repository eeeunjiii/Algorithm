import java.io.*;
import java.util.*;

public class Main {
    private static int T;
    private static int N;
    private static int[][] cnt=new int[42][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        cnt[0][0]=1;
        cnt[0][1]=0;
        cnt[1][0]=0;
        cnt[1][1]=1;

        T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());

            for(int j=2;j<=N;j++){
                cnt[j][0]=cnt[j-1][0]+cnt[j-2][0];
                cnt[j][1]=cnt[j-1][1]+cnt[j-2][1];
            }
            System.out.println(cnt[N][0]+" "+cnt[N][1]);
        }
    }
}