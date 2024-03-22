import java.io.*;
import java.util.*;

public class Main {

    private static int[][][] dp=new int[21][21][21]; // 21을 넘어가면 dp[20][20][20]을 반환

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int a, b, c;

        while(true) {
            StringTokenizer st=new StringTokenizer(br.readLine());

            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1) return;

            int w = w(a, b, c);
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w);
        }
    }
    private static int w(int a, int b, int c) {
        if(check(a, b, c) && dp[a][b][c]!=0) return dp[a][b][c]; // 이미 저장해놓은 dp 값이면 해당 값 반환 (메모)

        if(a<=0 || b<=0 || c<=0) return 1;

        if(a>20 || b>20 || c>20) return dp[20][20][20]=w(20, 20, 20);

        if(a<b && b<c) return dp[a][b][c]=w(a, b, c-1)+w(a, b-1, c-1)-w(a, b-1, c);

        else return dp[a][b][c]=w(a-1, b, c)+w(a-1, b-1, c)+w(a-1, b, c-1)-w(a-1, b-1, c-1);
    }

    private static boolean check(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}