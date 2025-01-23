import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N+1];
        boolean[][] dp=new boolean[N+1][N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++) {
            dp[i][i]=true;
        }

        for(int i=1;i<=N-1;i++) {
            if(arr[i]==arr[i+1]) dp[i][i+1]=true;
        }

        for(int i=2;i<N;i++) { // 팰린드롬인지 구하는 숫자의 길이
            for(int j=1;j<=N-i;j++) { // 길이가 2인 경우를 탐색하다 6번째 인덱스에 도달했을 때 범위가 넘어가는 것을 방지
                if(arr[j]==arr[j+i] && dp[j+1][j+i-1]) {
                    dp[j][j+i]=true;
                }
            }
        }

        int M=Integer.parseInt(br.readLine());

        StringBuilder sb=new StringBuilder();
        while(M-->0) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            if(dp[a][b]) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }

        System.out.println(sb);
    }
}