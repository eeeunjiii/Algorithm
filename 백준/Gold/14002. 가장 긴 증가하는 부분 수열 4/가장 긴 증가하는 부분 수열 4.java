import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N+1];
        int[] dp=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        // 가장 긴 증가하는 부분 수열 구하기
        int ans=0;
        for(int i=1;i<=N;i++) {
            for(int j=0;j<i;j++) {
                if(arr[i]>arr[j]) {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                    ans=Math.max(ans, dp[i]);
                }
            }
        }
        sb.append(ans).append("\n");

        Stack<Integer> stack=new Stack<>();
        for(int i=N;i>=1;i--) {
            if(dp[i]==ans) {
                stack.push(arr[i]);
                ans--;
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}